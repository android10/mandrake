package com.fernandocejas.mandrake.backend.features.jobs

import com.fernandocejas.mandrake.backend.RestApi.Companion.createEndpoint
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

const val JOBS_URI = "/jobs"

fun Application.jobRoutes() {
    routing {
        createJobRoute()
        runJobRoute()
        stopJobRoute()
        jobsByIdRoute()
        allJobsRoute()
        deleteJobRoute()
    }
}

private fun Route.createJobRoute() {
    post(createEndpoint(JOBS_URI)) {
        call.respondText("createJobRoute()")
    }
}

private fun Route.runJobRoute() {
    post(createEndpoint("$JOBS_URI/{id}/run")) {
        call.respondText("runJobRoute()")
    }
}

private fun Route.stopJobRoute() {
    post(createEndpoint("$JOBS_URI/{id}/stop")) {
        call.respondText("stopJobRoute()")
    }
}

private fun Route.deleteJobRoute() {
    delete(createEndpoint("$JOBS_URI/{id}")) {
        call.respondText("deleteJobRoute()")
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