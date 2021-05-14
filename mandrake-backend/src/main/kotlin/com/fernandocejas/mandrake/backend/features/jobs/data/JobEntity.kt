package com.fernandocejas.mandrake.backend.features.jobs.data

import com.fernandocejas.mandrake.backend.features.jobs.*
import org.jetbrains.exposed.dao.*
import org.jetbrains.exposed.dao.id.EntityID

class JobEntity(id: EntityID<Int>) : Entity<Int>(id) {

    companion object : EntityClass<Int, JobEntity>(Jobs)

    var name by Jobs.name

    fun toJob(): Job = Job(id.value, name, System.currentTimeMillis())
}