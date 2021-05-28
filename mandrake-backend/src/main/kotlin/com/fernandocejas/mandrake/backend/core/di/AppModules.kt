package com.fernandocejas.mandrake.backend.core.di

import com.fernandocejas.mandrake.backend.core.config.*
import com.fernandocejas.mandrake.backend.core.data.*
import com.fernandocejas.mandrake.backend.core.flags.*
import com.fernandocejas.mandrake.backend.core.log.*
import com.fernandocejas.mandrake.backend.core.health.*
import com.fernandocejas.mandrake.backend.features.jobs.di.*
import io.ktor.application.*
import org.koin.core.*
import org.koin.dsl.*

fun KoinApplication.loadModules(environment: ApplicationEnvironment): KoinApplication {
    val configModule = module {
        single { Configuration(environment, Feature.values()) }
        single { SanityChecker(environment, Feature.values()) } }

    return modules(configModule)
        .modules(mainAppModule)
        .modules(featuresModules)
}

/**
 * Main Application Module for Core Components
 * Dependency Injection.
 */
private val mainAppModule = module {
    single { FeatureFlags(get()) }
    single { DataConnector() }
    single { Log() }
}

/**
 * This list contains all the feature modules
 * for Dependency Injection.
 */
private val featuresModules = listOf(
    jobsModule
)