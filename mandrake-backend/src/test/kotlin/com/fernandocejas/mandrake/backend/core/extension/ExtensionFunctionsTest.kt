package com.fernandocejas.mandrake.backend.core.extension

import com.fernandocejas.mandrake.*
import org.amshove.kluent.*
import org.junit.*

class ExtensionFunctionsTest : UnitTest() {

    @Test
    fun `given an string literal, when String#empty is called, then should return empty`() {
        val emptyString = ""
        val emptyStringWithSpaces = " "

        String.empty() shouldBeEqualTo emptyString
        String.empty() shouldNotBeEqualTo emptyStringWithSpaces
    }

    @Test(expected = IllegalStateException::class)
    fun `given a failFast function, when called, then should throw an exception`() {
        failFast("I'm failing!!!")
    }
}