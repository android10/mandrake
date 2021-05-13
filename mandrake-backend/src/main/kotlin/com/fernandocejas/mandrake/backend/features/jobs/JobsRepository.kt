package com.fernandocejas.mandrake.backend.features.jobs

import com.fernandocejas.mandrake.backend.core.exception.*
import com.fernandocejas.mandrake.backend.core.functional.*

internal interface JobsRepository {
    fun createJob()
    fun getJobById(id: Int)
    fun deleteJob(id: Int)
    fun getAllJobs(): Either<Failure, List<Job>>
}