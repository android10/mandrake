/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
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
package com.fernandocejas.mandrake

import org.junit.*

/**
 * Base class for Unit tests. Inherit from it to create test in isolation where
 * all collaborators are dummy/fake/mock objects.
 */
abstract class UnitTest {

    @Suppress("LeakingThis")
    @Rule
    @JvmField val injectMocksRule = InjectMockKsRule.create(this@UnitTest)

    fun fail(message: String): Nothing = throw AssertionError(message)
}