package com.fernandocejas.mandrake.backend.core.extension

import com.fernandocejas.mandrake.backend.core.functional.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.util.pipeline.*

suspend inline fun <reified L: Any, reified R: Any> PipelineContext<Unit, ApplicationCall>.handleResponse(response: Either<L, R>) =
    response.coFold({ failure -> call.respond(failure) }, { success -> call.respond(success) })