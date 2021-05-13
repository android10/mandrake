package com.fernandocejas.mandrake.backend.features.jobs.data

import com.fernandocejas.mandrake.backend.core.exception.*
import com.fernandocejas.mandrake.backend.core.functional.*
import com.fernandocejas.mandrake.backend.features.jobs.*

class JobsDataSource(private val databaseDataSource: DatabaseDataSource) : JobsRepository {
    override fun createJob() = TODO("Not yet implemented")
    override fun getJobById(id: Int) = TODO("Not yet implemented")
    override fun deleteJob(id: Int) = TODO("Not yet implemented")

    override fun getAllJobs(): Either<Failure, List<Job>> =
        databaseDataSource.getAllJobs().map { entities -> entities.map { it.toJob() } }
}