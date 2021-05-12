package com.fernandocejas.mandrake.backend.core.extension

import com.fernandocejas.mandrake.backend.core.exception.*
import com.fernandocejas.mandrake.backend.core.functional.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.util.pipeline.*

suspend inline fun <reified Type: Any> PipelineContext<Unit, ApplicationCall>.handleResponse(response: Either<Failure, Type>) =
    response.coFold({ failure -> call.respond(failure) }, { success -> call.respond(HttpStatusCode.OK, success) })