package com.fernandocejas.mandrake.backend.core.config

import com.fernandocejas.mandrake.*
import com.fernandocejas.mandrake.backend.core.config.Environment.*
import com.fernandocejas.mandrake.backend.core.flags.*
import io.ktor.application.*
import io.ktor.config.*
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.amshove.kluent.*
import org.junit.*

class ConfigurationTest : UnitTest() {

    private lateinit var configuration: Configuration

    @MockK private lateinit var environment: ApplicationEnvironment
    @MockK private lateinit var config: ApplicationConfig
    @MockK private var appConfigValue: ApplicationConfigValue? = null
    @MockK private lateinit var activatedFeatureOne: Feature
    @MockK private lateinit var activatedFeatureTwo: Feature

    @Before
    fun setup() {
        every { appConfigValue?.getString() } returns ENV_DEVELOPMENT
        every { config.propertyOrNull(any()) } returns appConfigValue
        every { environment.config } returns config
        every { activatedFeatureOne.name } returns FEATURE_ONE
        every { activatedFeatureTwo.name } returns FEATURE_TWO
    }

    @Test
    fun `given Application Environment in configuration file, then should map correctly at app level`() {
        every { appConfigValue?.getString() } returns ENV_DEVELOPMENT
        configuration = Configuration(environment, arrayOf(activatedFeatureOne, activatedFeatureTwo))
        configuration.appEnvironment shouldBe DEVELOPMENT

        every { appConfigValue?.getString() } returns ENV_STAGING
        configuration = Configuration(environment, arrayOf(activatedFeatureOne, activatedFeatureTwo))
        configuration.appEnvironment shouldBe STAGING

        every { appConfigValue?.getString() } returns ENV_PRODUCTION
        configuration = Configuration(environment, arrayOf(activatedFeatureOne, activatedFeatureTwo))
        configuration.appEnvironment shouldBe PRODUCTION
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given invalid Application Environment in configuration file, then should fail fast`() {
        every { appConfigValue?.getString() } returns "MY_ENVIRONMENT"
        configuration = Configuration(environment, arrayOf(activatedFeatureOne, activatedFeatureTwo))
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given null Application Environment in configuration file, then should fail fast`() {
        every { config.propertyOrNull(any()) } returns null
        configuration = Configuration(environment, arrayOf(activatedFeatureOne, activatedFeatureTwo))
    }

    @Test
    fun `given true Development Mode value in configuration file, then should map correctly at app level`() {
        every { environment.developmentMode } returns true
        configuration = Configuration(environment, arrayOf(activatedFeatureOne, activatedFeatureTwo))

        configuration.developmentMode shouldBe true
    }

    @Test
    fun `given false Development Mode value in configuration file, then should map correctly at app level`() {
        every { environment.developmentMode } returns false
        configuration = Configuration(environment, arrayOf(activatedFeatureOne, activatedFeatureTwo))

        configuration.developmentMode shouldBe false
    }

    @Test
    fun `given activated Feature Flags, when App Configuration is built, then activated flags should be accessible`() {
        val activatedFeatures = arrayOf(activatedFeatureOne, activatedFeatureTwo)

        every { appConfigValue?.getList() } returns listOf("DEVELOPMENT")
        every { environment.toString() } returns "DEVELOPMENT"

        configuration = Configuration(environment, activatedFeatures)

        configuration.activatedFeatures shouldContainAll activatedFeatures
    }

    @Test
    fun `given activated Feature Flags on a different environment, when App Configuration is built, then flags should not be accessible`() {
        val activatedFeatures = arrayOf(activatedFeatureOne, activatedFeatureTwo)

        every { appConfigValue?.getList() } returns listOf(ENV_PRODUCTION)
        every { environment.toString() } returns ENV_DEVELOPMENT

        configuration = Configuration(environment, activatedFeatures)

        configuration.activatedFeatures shouldNotContainAny activatedFeatures
    }

    companion object {
        private const val FEATURE_ONE = "HELLO"
        private const val FEATURE_TWO = "BYE"

        private const val ENV_DEVELOPMENT = "DEVELOPMENT"
        private const val ENV_STAGING = "STAGING"
        private const val ENV_PRODUCTION = "PRODUCTION"
    }
}