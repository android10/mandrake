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
package com.fernandocejas.mandrake.backend.core.health

import com.fernandocejas.mandrake.backend.core.config.*
import com.fernandocejas.mandrake.backend.core.flags.*
import io.ktor.application.*

class SanityChecker(private val environment: ApplicationEnvironment,
                    private val features: Array<Feature>) {

    /**
     * Performs a set of sanity checks in order to run the system safer.
     *
     * @see [validateFeatureFlags]
     */
    fun perform() = validateFeatureFlags()

    /**
     * Being defensive here due to the nature of HOCON files using String literals:
     *  - Make sure Feature names match with {Feature.kt}.
     *  - Make sure enabled environments match with {}.
     */
    private fun validateFeatureFlags() {
        features.map {
            val feature = environment.config.propertyOrNull("${Configuration.PROPERTY_FEATURES}.${it.name}")
            requireNotNull(feature) { "INVALID Feature Flags Configuration: Check 'application.conf', 'features' section." }
            feature.getList().map { environment -> Environment.valueOf(environment) }
        }
    }
}