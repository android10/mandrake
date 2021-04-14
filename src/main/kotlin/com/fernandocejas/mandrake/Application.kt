package com.fernandocejas.mandrake

import com.fernandocejas.mandrake.backend.*
import com.fernandocejas.mandrake.backend.features.auth.*
import com.fernandocejas.mandrake.backend.features.jobs.*
import com.fernandocejas.mandrake.frontend.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    setupServer()
    initializeRouting()
}

private fun Application.setupServer() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation)
}

private fun Application.initializeRouting() {
    routing {
        webRoutes()
        apiRoutes()
    }
}