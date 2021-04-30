package com.fernandocejas.mandrake.backend.features.jobs

import kotlinx.serialization.Serializable

@Serializable
class Job(val id: String, val name: String, val created: Long,
          val type: Type = Type.ON_DEMAND, val status: Status = Status.IDLE, ) {

    enum class Type {
        ON_DEMAND,
        CRON
    }

    enum class Status {
        IDLE,
        RUNNING,
        STOPPED,
        CANCELLED,
        WAITING
    }
}