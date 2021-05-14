package com.fernandocejas.mandrake.backend.core.data

import com.fernandocejas.mandrake.backend.features.jobs.data.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*
import java.io.*
import java.sql.*

class DataConnector {

    companion object {
        private const val DATABASE_NAME = "mandrake.db"
        private const val DATABASE_FILE_PATH = "db/${DATABASE_NAME}"
        private const val DATABASE_URL = "jdbc:sqlite:${DATABASE_FILE_PATH}"
        private const val DATABASE_DRIVER = "org.sqlite.JDBC"
    }

    fun initialize() {
        createDbFile()
        setupDbConnection()
        createDbTables()
        prepopulateTables()
    }

    private fun createDbFile() {
        val databaseFile = File(DATABASE_FILE_PATH)
        if (!databaseFile.exists()) databaseFile.createNewFile()
    }

    private fun setupDbConnection() {
        Database.connect(DATABASE_URL, DATABASE_DRIVER)
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
    }

    private fun createDbTables() {
        transaction {
            SchemaUtils.create(Jobs)
        }
    }

    private fun prepopulateTables() {
        //TODO: ??? fill the tables with valid Data
        //TODO: ??? check if data already exists
    }
}