package com.fernandocejas.mandrake.backend.info

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.serialization.*

const val INFO_URI = "/"

fun Application.infoRoutes() {
    routing {
        infoRoute()
    }
}

private fun Route.infoRoute() {
    get(INFO_URI) {
        // TODO: Provide a logo and links to the different sections
        call.respond(MandrakeInfo(name = "Mandrake", version = "0.0.1"))
    }
}

@Serializable
data class MandrakeInfo(private val name: String, private val version: String)