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
package com.fernandocejas.mandrake.backend.core.flags

import com.fernandocejas.mandrake.backend.core.config.*

/**
 * Feature flags states (activated/deactivated) can be used as conditionals.
 *
 * ### Example:
 *
 * ```Flag.Conversations whenActivated { fn } otherwise { fn }```
 */
class FeatureFlags(configuration: Configuration) {

    private val activatedFeatures: Set<Feature> = configuration.activatedFeatures

    private fun isFeatureEnabled(feature: Feature) = activatedFeatures.contains(feature)

    fun whenActivated(feature: Feature, fnFeatureEnabled: () -> Unit): Condition {
        val enabled = isFeatureEnabled(feature)
        if (enabled) fnFeatureEnabled.invoke(); return Condition(enabled)
    }

    inner class Condition(private val expression: Boolean) {
        infix fun otherwise(otherwise: () -> Unit) {
            if (!expression) otherwise.invoke()
        }
    }
}