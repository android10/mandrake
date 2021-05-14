package com.fernandocejas.mandrake.backend.core.di

import com.fernandocejas.mandrake.backend.core.data.*
import com.fernandocejas.mandrake.backend.features.jobs.di.*
import org.koin.dsl.*

val mainModule = module {
    single { DataConnector() }
}

val applicationModules = listOf(
    mainModule,
    jobsModule
)
