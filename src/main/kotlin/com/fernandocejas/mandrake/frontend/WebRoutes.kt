package com.fernandocejas.mandrake.frontend

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.webRoutes() {
    routing {
        webRoute()
    }
}

private fun Route.webRoute() {
    get("/") {
        call.respondText("WELCOME TO MANDRAKE!!!")
    }
}