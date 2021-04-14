package com.fernandocejas.mandrake.features.jobs

import com.fernandocejas.mandrake.core.api.RestApi.Companion.createEndpoint
import io.ktor.application.*
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
        TODO()
    }
}

private fun Route.jobsByIdRoute() {
    get(createEndpoint("$JOBS_URI/{id}")) {
        TODO()
    }
}

private fun Route.allJobsRoute() {
    get(createEndpoint(JOBS_URI)) {
        TODO()
    }
}
