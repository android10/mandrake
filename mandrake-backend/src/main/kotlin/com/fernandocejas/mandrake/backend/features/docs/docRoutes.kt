package com.fernandocejas.mandrake.backend.features.docs

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

const val DOCS_URI = "/"

fun Application.docRoutes() {
    routing {
        get(DOCS_URI) {
            call.respondText("HERE IS THE DOCUMENTATION.")
        }
    }
}

