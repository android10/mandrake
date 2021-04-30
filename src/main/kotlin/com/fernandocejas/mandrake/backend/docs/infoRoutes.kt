package com.fernandocejas.mandrake.backend.docs

import com.fernandocejas.mandrake.backend.*
import com.fernandocejas.mandrake.backend.info.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

const val DOCS_URI = "/docs"

fun Application.docRoutes() {
    routing {
        docRoute()
    }
}

private fun Route.docRoute() {
    get(INFO_URI.plus(RestApi.rootUri())) {
        call.respondText("THIS IS THE DOCUMENTATION")
    }
}