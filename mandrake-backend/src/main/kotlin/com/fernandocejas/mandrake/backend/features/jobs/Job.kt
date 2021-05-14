package com.fernandocejas.mandrake.backend.features.jobs

import kotlinx.serialization.Serializable

@Serializable
data class Job(val id: Int,
               val name: String,
               val created: Long,
               val status: Status = Status.IDLE) {

    enum class Status {
        IDLE,
        RUNNING,
        STOPPED,
        CANCELLED,
        WAITING
    }
}