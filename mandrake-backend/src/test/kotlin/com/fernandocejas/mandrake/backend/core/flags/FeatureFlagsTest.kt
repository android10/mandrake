package com.fernandocejas.mandrake.backend.core.flags

import com.fernandocejas.mandrake.*
import com.fernandocejas.mandrake.backend.core.config.*
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.*

class FeatureFlagsTest : UnitTest() {

    private lateinit var featureFlags: FeatureFlags

    @MockK
    private lateinit var configuration: Configuration
    @MockK
    private lateinit var greeter: Greeter

    @Test
    fun `given a feature flag, when it is activated, then executes given logic block`() {
        val activatedFeatureFlag = mockk<Feature>(relaxed = true)

        every { configuration.activatedFeatures } returns setOf(activatedFeatureFlag)
        featureFlags = FeatureFlags(configuration)

        featureFlags.whenActivated(activatedFeatureFlag) {
            greeter.sayHelloActiveFeature()
            greeter.greet()
            greeter.greet()
        }

        verify(exactly = 1) { configuration.activatedFeatures }
        verify(exactly = 1) { greeter.sayHelloActiveFeature() }
        verify(exactly = 2) { greeter.greet() }
    }

    @Test
    fun `given a feature flag, when it is deactivated, then does not execute given logic block`() {
        val deActivatedFeatureFlag = mockk<Feature>(relaxed = true)

        every { configuration.activatedFeatures } returns emptySet()
        featureFlags = FeatureFlags(configuration)

        featureFlags.whenActivated(deActivatedFeatureFlag) {
            greeter.greet()
            greeter.sayHelloActiveFeature()
            greeter.greet()
        }

        verify { greeter wasNot Called }
    }

    @Test
    fun `given a feature flag, when it is activated, then does not execute given 'otherwise' logic block`() {
        val activatedFeatureFlag = mockk<Feature>(relaxed = true)

        every { configuration.activatedFeatures } returns setOf(activatedFeatureFlag)
        featureFlags = FeatureFlags(configuration)

        featureFlags.whenActivated(activatedFeatureFlag) {
            greeter.greet()
            greeter.sayHelloActiveFeature()
            greeter.greet()
        } otherwise {
            greeter.sayByeInactiveFeature()
        }

        verify(exactly = 1) { greeter.sayHelloActiveFeature() }
        verify(exactly = 2) { greeter.greet() }
        verify(inverse = true) { greeter.sayByeInactiveFeature() }
    }

    @Test
    fun `given a feature flag, when it is deactivated, then execute given 'otherwise' logic block`() {
        val deActivatedFeatureFlag = mockk<Feature>(relaxed = true)

        every { configuration.activatedFeatures } returns emptySet()
        featureFlags = FeatureFlags(configuration)

        featureFlags.whenActivated(deActivatedFeatureFlag) {
            greeter.greet()
            greeter.sayHelloActiveFeature()
            greeter.greet()
        } otherwise {
            greeter.sayByeInactiveFeature()
        }

        verify(inverse = true) { greeter.sayHelloActiveFeature() }
        verify(inverse = true) { greeter.greet() }
        verify(exactly = 1) { greeter.sayByeInactiveFeature() }
    }

    private class Greeter {
        fun greet() { this.hashCode() }
        fun sayHelloActiveFeature() { this.hashCode() }
        fun sayByeInactiveFeature() { this.hashCode() }
    }
}