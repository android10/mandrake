package com.fernandocejas.mandrake.backend.features.jobs

import com.fernandocejas.mandrake.backend.core.exception.*
import com.fernandocejas.mandrake.backend.core.functional.*
import com.fernandocejas.mandrake.backend.core.interactor.*

internal class GetJobs(private val jobsRepository: JobsRepository) : UseCase<List<Job>, UseCase.None>() {
    override fun run(params: None): Either<Failure, List<Job>> = jobsRepository.getAllJobs()
}