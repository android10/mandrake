package com.fernandocejas.mandrake.backend.core.flags

import com.fernandocejas.mandrake.*

class FeatureFlagsTest : UnitTest() {

//    @Test
//    fun `given a feature flag, when it is activated, then executes given logic block`() {
//        val activeFlag = ActiveFeatureFlag()
//        val fakeGreeter = mockk<Greeter>(relaxed = true)
//
//        activeFlag whenActivated {
//            fakeGreeter.greet()
//            fakeGreeter.sayHelloActiveFeature()
//            fakeGreeter.greet()
//        }
//
//        verify(exactly = 1) { fakeGreeter.sayHelloActiveFeature() }
//        verify(exactly = 2) { fakeGreeter.greet() }
//    }
//
//    @Test
//    fun `given a feature flag, when it is deactivated, then does not execute given logic block`() {
//        val inactiveFlag = InactiveFeatureFlag()
//        val fakeNavigator = mockk<Greeter>(relaxed = true)
//
//        inactiveFlag whenActivated {
//            fakeNavigator.greet()
//            fakeNavigator.sayHelloActiveFeature()
//            fakeNavigator.greet()
//        }
//
//        verify { fakeNavigator wasNot Called }
//    }
//
//    @Test
//    fun `given a feature flag, when it is activated, then does not execute given 'otherwise' logic block`() {
//        val activeFlag = ActiveFeatureFlag()
//        val fakeNavigator = mockk<Greeter>(relaxed = true)
//
//        activeFlag whenActivated {
//            fakeNavigator.greet()
//            fakeNavigator.sayHelloActiveFeature()
//            fakeNavigator.greet()
//        } otherwise {
//            fakeNavigator.sayByeInactiveFeature()
//        }
//
//        verify(exactly = 1) { fakeNavigator.sayHelloActiveFeature() }
//        verify(exactly = 2) { fakeNavigator.greet() }
//        verify(inverse = true) { fakeNavigator.sayByeInactiveFeature() }
//    }
//
//    @Test
//    fun `given a feature flag, when it is deactivated, then execute given 'otherwise' logic block`() {
//        val inactiveFlag = InactiveFeatureFlag()
//        val fakeNavigator = mockk<Greeter>(relaxed = true)
//
//        inactiveFlag whenActivated {
//            fakeNavigator.greet()
//            fakeNavigator.sayHelloActiveFeature()
//            fakeNavigator.greet()
//        } otherwise {
//            fakeNavigator.sayByeInactiveFeature()
//        }
//
//        verify(inverse = true) { fakeNavigator.sayHelloActiveFeature() }
//        verify(inverse = true) { fakeNavigator.greet() }
//        verify(exactly = 1) { fakeNavigator.sayByeInactiveFeature() }
//    }

//    private class ActiveFeatureFlag : FeatureFlag(enabled = true)
//    private class InactiveFeatureFlag : FeatureFlag(enabled = false)

    private class Greeter {
        fun greet() { this.hashCode() }
        fun sayHelloActiveFeature() { this.hashCode() }
        fun sayByeInactiveFeature() { this.hashCode() }
    }
}