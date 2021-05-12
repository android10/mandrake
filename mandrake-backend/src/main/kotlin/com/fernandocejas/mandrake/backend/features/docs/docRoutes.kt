package com.fernandocejas.mandrake.backend.features.docs

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.docRoutes() {
    routing {
        get("/") {
            call.respondText("HERE IS THE DOCUMENTATION.")
        }
    }
}

