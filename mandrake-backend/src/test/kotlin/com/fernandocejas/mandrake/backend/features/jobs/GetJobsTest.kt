package com.fernandocejas.mandrake.backend.features.jobs

import com.fernandocejas.mandrake.*
import org.amshove.kluent.*
import org.junit.*

class GetJobsTest : UnitTest() {

    private lateinit var getJobs: GetJobs

    @Before
    fun setup() {
        getJobs = GetJobs()
    }

    @Test
    fun `this is a test`() {
        true shouldBe true
    }
}