package com.fernandocejas.mandrake

import com.fernandocejas.mandrake.backend.*
import com.fernandocejas.mandrake.backend.info.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.cio.EngineMain.main(args)

fun Application.module() {
    setupServer()
    initializeRouting()
}

private fun Application.setupServer() {
    install(DefaultHeaders)
    install(CallLogging)
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
        }
    }
}

private fun Application.initializeRouting() {
    routing {
        infoRoutes()
        apiRoutes()
    }
}