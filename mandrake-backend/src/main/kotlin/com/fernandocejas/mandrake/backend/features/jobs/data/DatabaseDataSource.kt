package com.fernandocejas.mandrake.backend.features.jobs.data

import com.fernandocejas.mandrake.backend.core.exception.*
import com.fernandocejas.mandrake.backend.core.functional.*

class DatabaseDataSource {
    fun getAllJobs(): Either<Failure, List<JobEntity>> {
        // TODO: Handle correctly db errors.
        val jobEntities = listOf(JobEntity(), JobEntity())
        return Either.Right(jobEntities)
    }
}