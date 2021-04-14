package com.fernandocejas.mandrake

import com.fernandocejas.mandrake.core.api.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.mainRoutes() {
    routing {
        mainRoute()
    }
}

private fun Route.mainRoute() {
    get(RestApi.rootUri()) {
        call.respondText("${RestApi.name()} - ${RestApi.version()}")
    }
}