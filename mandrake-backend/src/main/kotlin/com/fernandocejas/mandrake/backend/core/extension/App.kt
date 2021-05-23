package com.fernandocejas.mandrake.backend.core.extension

import com.fernandocejas.mandrake.backend.core.config.*
import io.ktor.application.*
import org.koin.ktor.ext.*

val Application.configuration: Configuration
    get() {
        val config by inject<Configuration>()
        return config
    }

//TODO: Work on Feature Flags
val Application.features: Configuration
    get() {
        val config by inject<Configuration>()
        return config
    }

fun failFast(reason: String): Nothing = throw IllegalStateException(reason)