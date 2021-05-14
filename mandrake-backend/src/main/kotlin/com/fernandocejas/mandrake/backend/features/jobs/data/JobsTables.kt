package com.fernandocejas.mandrake.backend.features.jobs.data

import org.jetbrains.exposed.dao.id.*
import org.jetbrains.exposed.sql.jodatime.*

object Jobs : IntIdTable("JOBS") {
    val name = varchar("name", 50)
    val created = datetime("created").defaultValueFun
}

