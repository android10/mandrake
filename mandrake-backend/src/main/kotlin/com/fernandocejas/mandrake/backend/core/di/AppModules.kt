package com.fernandocejas.mandrake.backend.core.di

import com.fernandocejas.mandrake.backend.core.config.*
import com.fernandocejas.mandrake.backend.core.data.*
import com.fernandocejas.mandrake.backend.features.jobs.di.*
import io.ktor.application.*
import org.koin.core.*
import org.koin.dsl.*

fun KoinApplication.loadModules(environment: ApplicationEnvironment): KoinApplication {
    val configModule = module { single { Configuration(environment) } }
    return modules(listOf(configModule))
        .modules(mainAppModule)
        .modules(featuresModules)
}

/**
 * Main Application Module for Core Components
 * Dependency Injection.
 */
private val mainAppModule = module {
    single { DataConnector() }
}

/**
 * This list contains all the feature modules
 * for Dependency Injection.
 */
private val featuresModules = listOf(
    jobsModule
)