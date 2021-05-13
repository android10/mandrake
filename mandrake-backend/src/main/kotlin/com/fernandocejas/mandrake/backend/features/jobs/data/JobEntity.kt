package com.fernandocejas.mandrake.backend.features.jobs.data

import com.fernandocejas.mandrake.backend.features.jobs.*

class JobEntity {
    fun toJob(): Job =
        Job("1", "Test Job 1", System.currentTimeMillis())
}