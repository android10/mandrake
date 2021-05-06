package com.fernandocejas.mandrake.backend.features.jobs

import com.fernandocejas.mandrake.backend.RestApi.Companion.createEndpoint
import com.fernandocejas.mandrake.backend.core.interactor.*
import com.fernandocejas.mandrake.backend.core.interactor.UseCase.*
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
        call.respond(Job("1", "test Job", System.currentTimeMillis()))
    }
}

private fun Route.jobsByIdRoute() {
    get(createEndpoint("$JOBS_URI/{id}")) {
        call.respond(Job("1", "test Job", System.currentTimeMillis()))
//        call.respondText("Job ID: ${call.parameters["id"].toString()}")
    }
}

private fun Route.runJobRoute() {
    post(createEndpoint("$JOBS_URI/{id}/run")) {
        call.respondText("Job ID: ${call.parameters["id"].toString()}")
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

private fun Route.allJobsRoute() {
//    Lazy inject GetJobs UseCase from within a Ktor Route
//    val service by inject<GetJobs>()
    val getJobs = GetJobs()

    get(createEndpoint(JOBS_URI)) {
        // TODO: Deal with the result
        getJobs.run(None()).fold({}, {})
        call.respondText("allJobsRoute()")
    }
}
