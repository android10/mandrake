package com.fernandocejas.mandrake.backend.core.health

import com.fernandocejas.mandrake.*
import com.fernandocejas.mandrake.backend.core.flags.*
import io.ktor.application.*
import io.ktor.config.*
import io.mockk.*
import io.mockk.impl.annotations.*
import io.mockk.impl.annotations.MockK
import org.junit.*
import org.junit.Assert.*

class SanityCheckerTest : UnitTest() {

    @MockK private lateinit var environment: ApplicationEnvironment
    @MockK private lateinit var config: ApplicationConfig
    @MockK private var appConfigValue: ApplicationConfigValue? = null
    @MockK private lateinit var activatedFeatureOne: Feature

    @Test(expected = IllegalArgumentException::class)
    fun `given a null or invalid Feature configuration, when sanity check is performed, then it should fail fast`() {
        every { config.propertyOrNull(any()) } returns null
        every { environment.config } returns config

        SanityChecker(environment, arrayOf(activatedFeatureOne)).perform()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given an invalid Environment in configuration file, when sanity check is performed, then it should fail fast`() {
        every { appConfigValue?.getList() } returns listOf("MY_ENVIRONMENT")
        every { config.propertyOrNull(any()) } returns appConfigValue
        every { environment.config } returns config

        SanityChecker(environment, arrayOf(activatedFeatureOne)).perform()
    }
}