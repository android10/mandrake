package com.fernandocejas.mandrake.backend.features.jobs

import com.fernandocejas.mandrake.backend.RestApi.Companion.createEndpoint
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

const val JOBS_URI = "/jobs"

fun Application.jobRoutes() {
    routing {
        createJobRoute()
        jobsByIdRoute()
        allJobsRoute()
    }
}

private fun Route.createJobRoute() {
    post(createEndpoint(JOBS_URI)) {
        call.respondText("createJobRoute()")
    }
}

private fun Route.jobsByIdRoute() {
    get(createEndpoint("$JOBS_URI/{id}")) {
        call.respondText("jobsByIdRoute()")
    }
}

private fun Route.allJobsRoute() {
    get(createEndpoint(JOBS_URI)) {
        call.respondText("allJobsRoute()")
    }
}
