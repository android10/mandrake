package com.fernandocejas.mandrake.frontend

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.Serializable

fun Application.webRoutes() {
    routing {
        webRoute()
    }
}

private fun Route.webRoute() {
    get("/") {
        call.respond(MandrakeApplication(name = "Mandrake", version = "0.0.1"))
    }
}

@Serializable
data class MandrakeApplication(val name: String, val version: String)