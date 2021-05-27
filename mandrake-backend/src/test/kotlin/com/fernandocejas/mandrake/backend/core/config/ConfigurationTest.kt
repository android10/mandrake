package com.fernandocejas.mandrake.backend.core.config

import com.fernandocejas.mandrake.*
import com.fernandocejas.mandrake.backend.core.config.Environment.*
import io.ktor.application.*
import io.ktor.config.*
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.amshove.kluent.*
import org.junit.*

class ConfigurationTest : UnitTest() {

    private lateinit var configuration: Configuration

    @MockK
    private lateinit var environment: ApplicationEnvironment
    @MockK
    private lateinit var config: ApplicationConfig
    @MockK
    private var appConfigValue: ApplicationConfigValue? = null

    @Before
    fun setup() {
        every { appConfigValue?.getString() } returns "DEVELOPMENT"
        every { config.propertyOrNull(any()) } returns appConfigValue
        every { environment.config } returns config
    }

    @Test
    fun `given Application Environment in configuration file, then should map correctly at app level`() {
        every { appConfigValue?.getString() } returns "DEVELOPMENT"
        configuration = Configuration(environment)
        configuration.appEnvironment shouldBe DEVELOPMENT

        every { appConfigValue?.getString() } returns "STAGING"
        configuration = Configuration(environment)
        configuration.appEnvironment shouldBe STAGING

        every { appConfigValue?.getString() } returns "PRODUCTION"
        configuration = Configuration(environment)
        configuration.appEnvironment shouldBe PRODUCTION
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given invalid Application Environment in configuration file, then should fail fast`() {
        every { appConfigValue?.getString() } returns "MY_ENVIRONMENT"
        configuration = Configuration(environment)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given null Application Environment in configuration file, then should fail fast`() {
        every { config.propertyOrNull(any()) } returns null
        configuration = Configuration(environment)
    }

    @Test
    fun `given true Development Mode value in configuration file, then should map correctly at app level`() {
        every { environment.developmentMode } returns true
        configuration = Configuration(environment)

        configuration.developmentMode shouldBe true
    }

    @Test
    fun `given false Development Mode value in configuration file, then should map correctly at app level`() {
        every { environment.developmentMode } returns false
        configuration = Configuration(environment)

        configuration.developmentMode shouldBe false
    }
}