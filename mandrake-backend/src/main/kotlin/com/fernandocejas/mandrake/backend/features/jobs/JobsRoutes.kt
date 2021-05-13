package com.fernandocejas.mandrake.backend.features.jobs

import com.fernandocejas.mandrake.backend.RestApi.Companion.createEndpoint
import com.fernandocejas.mandrake.backend.core.extension.*
import com.fernandocejas.mandrake.backend.core.interactor.UseCase.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.*

fun Application.jobsRoutes() {
    routing {
        createJobRoute()
        runJobRoute()
        stopJobRoute()
        getJobByIdRoute()
        allJobsRoute()
        deleteJobRoute()
    }
}

private fun Route.createJobRoute() {
    post(createEndpoint("/jobs")) {
        call.respond(Job("1", "test Job", System.currentTimeMillis()))
    }
}

private fun Route.getJobByIdRoute() {
    get(createEndpoint("/jobs/{id}")) {
        call.respondText("Job ID: ${call.parameters["id"].toString()}")
    }
}

private fun Route.runJobRoute() {
    post(createEndpoint("/jobs/{id}/run")) {
        call.respondText("Job ID: ${call.parameters["id"].toString()}")
    }
}

private fun Route.stopJobRoute() {
    post(createEndpoint("/jobs/{id}/stop")) {
        call.respondText("stopJobRoute()")
    }
}

private fun Route.deleteJobRoute() {
    delete(createEndpoint("/jobs/{id}")) {
        call.respondText("deleteJobRoute()")
    }
}

private fun Route.allJobsRoute() {
    val getJobs by inject<GetJobs>()

    get(createEndpoint("/jobs")) {
        handleResponse(getJobs(None()))
    }
}
