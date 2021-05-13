package com.fernandocejas.mandrake

import com.fernandocejas.mandrake.backend.*
import com.fernandocejas.mandrake.backend.features.docs.*
import com.fernandocejas.mandrake.backend.features.jobs.di.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import org.koin.ktor.ext.*
import org.koin.logger.*

fun main(args: Array<String>): Unit = io.ktor.server.cio.EngineMain.main(args)

fun Application.module() {
    setupServer()
    initializeRouting()
}

private fun Application.setupServer() {
    install(CallLogging)
    install(DefaultHeaders) {
        header("Mandrake-Developer", "Fernando Cejas")
    }
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
        }
    }
    install(Koin) {
        slf4jLogger()
        modules(jobsModule)
    }
}

private fun Application.initializeRouting() {
    routing {
        docRoutes()
        apiRoutes()
    }
}