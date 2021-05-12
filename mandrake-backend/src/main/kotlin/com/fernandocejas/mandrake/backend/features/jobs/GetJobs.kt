package com.fernandocejas.mandrake.backend.features.jobs

import com.fernandocejas.mandrake.backend.core.exception.*
import com.fernandocejas.mandrake.backend.core.functional.*
import com.fernandocejas.mandrake.backend.core.interactor.*

class GetJobs : UseCase<List<Job>, UseCase.None>() {
    override fun run(params: None): Either<Failure, List<Job>> {

        // TODO: Refactor to use the repository for handling Jobs.
        // TODO: Handle correctly server errors.
        val jobList =   listOf(
            Job("1", "Test Job 1", System.currentTimeMillis()),
            Job("2", "Test Job 2", System.currentTimeMillis()),
            Job("3", "Test Job 3", System.currentTimeMillis()),
            Job("4", "Test Job 4", System.currentTimeMillis()),
            Job("5", "Test Job 5", System.currentTimeMillis()),
            Job("6", "Test Job 6", System.currentTimeMillis()),
        )

        return Either.Right(jobList)
    }
}