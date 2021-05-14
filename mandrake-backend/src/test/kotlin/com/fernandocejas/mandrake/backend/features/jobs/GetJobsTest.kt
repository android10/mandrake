package com.fernandocejas.mandrake.backend.features.jobs

import com.fernandocejas.mandrake.*
import io.mockk.impl.annotations.*
import org.amshove.kluent.*
import org.junit.*

class GetJobsTest : UnitTest() {

    private lateinit var getJobs: GetJobs

    @MockK private lateinit var jobsRepository: JobsRepository

    @Before
    fun setup() {
        getJobs = GetJobs(jobsRepository)
    }

    @Test
    fun `this is a test`() {
        true shouldBe true
    }
}