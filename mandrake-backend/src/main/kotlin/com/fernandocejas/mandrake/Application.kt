package com.fernandocejas.mandrake

import com.fernandocejas.mandrake.backend.*
import com.fernandocejas.mandrake.backend.core.data.*
import com.fernandocejas.mandrake.backend.core.di.*
import com.fernandocejas.mandrake.backend.core.health.*
import com.fernandocejas.mandrake.backend.features.docs.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import org.koin.ktor.ext.*
import org.koin.logger.*

fun main(args: Array<String>): Unit = io.ktor.server.cio.EngineMain.main(args)

fun Application.module() {
    setupServer()
    sanityCheck()
    initializeDatabase()
    initializeRouting()
}

private fun Application.setupServer() {
    install(CallLogging)
    install(DefaultHeaders)
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
            serializeNulls()
        }
    }
    install(Koin) {
        slf4jLogger()
        loadModules(environment)
    }
}

private fun Application.sanityCheck() {
    val sanityChecker by inject<SanityChecker>()
    sanityChecker.perform()
}

fun Application.initializeDatabase() {
    val dataConnector by inject<DataConnector>()
    dataConnector.initialize()
}

private fun Application.initializeRouting() {
    routing {
        docRoutes()
        apiRoutes()
    }
}