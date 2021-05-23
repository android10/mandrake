package com.fernandocejas.mandrake.backend.core.config

import io.ktor.application.*

/**
 * Application specific custom configuration.
 * Properties should match and exist in the application configuration file.
 *
 * @see application.conf
 */
class Configuration(private val environment: ApplicationEnvironment) {

    val developmentMode = environment.developmentMode
    val appEnvironment = mapEnvironment(environment)

    private fun mapEnvironment(environment: ApplicationEnvironment): Environment {
        val environmentProperty = environment.config.propertyOrNull(PROPERTY_ENVIRONMENT)
        requireNotNull(environmentProperty)

        return Environment.valueOf(environmentProperty.getString())
    }

    companion object {
        /**
         * Properties should match with values provided in the
         * application configuration file.
         *
         * @see application.conf
         * @see https://ktor.io/docs/configurations.html
         */
        private const val PROPERTY_ENVIRONMENT = "ktor.environment"
    }

    enum class Environment {
        PRODUCTION,
        STAGING,
        DEVELOPMENT
    }
}