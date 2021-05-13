package com.fernandocejas.mandrake.backend.features.jobs.di

import com.fernandocejas.mandrake.backend.features.jobs.*
import com.fernandocejas.mandrake.backend.features.jobs.data.*
import org.koin.dsl.*

val jobsModule = module {
    single { DatabaseDataSource() }
    single<JobsRepository> { JobsDataSource(get()) }
    factory { GetJobs(get()) }
}