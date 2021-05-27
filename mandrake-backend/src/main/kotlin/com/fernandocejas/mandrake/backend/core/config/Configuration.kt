/**
 * Copyright (C) 2021 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fernandocejas.mandrake.backend.core.config

import com.fernandocejas.mandrake.backend.core.flags.*
import io.ktor.application.*
import org.koin.core.component.*

/**
 * Application specific global custom configuration.
 * Properties should match and exist in the application configuration file.
 *
 * @see [application.conf]
 */
class Configuration(private val environment: ApplicationEnvironment) {

    val developmentMode = environment.developmentMode
    val appEnvironment = mapEnvironment(environment)
    val activatedFeatures: Set<Feature> = populateActivatedFeature(environment)

    private fun mapEnvironment(environment: ApplicationEnvironment): Environment {
        val environmentProperty = environment.config.propertyOrNull(PROPERTY_ENVIRONMENT)
        requireNotNull(environmentProperty) { "INVALID Environment Configuration: Check 'application.conf'" }

        return Environment.valueOf(environmentProperty.getString())
    }

    private fun populateActivatedFeature(environment: ApplicationEnvironment): Set<Feature> {
        val activatedFeatures: MutableSet<Feature> = mutableSetOf()

        Feature.values().forEach {
            val feature = environment.config.propertyOrNull("${PROPERTY_FEATURES}.${it.name}")
            feature?.getList()?.map { environment ->
                if (environment == appEnvironment.toString()) {
                    activatedFeatures.add(it)
                }
                return@forEach
            }
        }
        return activatedFeatures
    }

    companion object {
        /**
         * Properties should match with values provided in the
         * application configuration file.
         *
         * @see [application.conf]
         * @link https://ktor.io/docs/configurations.html
         */
        private const val PROPERTY_ENVIRONMENT = "ktor.environment"
        const val PROPERTY_FEATURES = "ktor.features"
    }
}