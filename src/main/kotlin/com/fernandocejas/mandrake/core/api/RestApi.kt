package com.fernandocejas.mandrake.core.api

import com.fernandocejas.mandrake.core.extension.*

class RestApi private constructor(){

    companion object {
        private const val REST_API_NAME = "Mandrake REST Api"
        private const val REST_API_SEPARATOR = "/"
        private const val REST_API_URI = "api"
        private const val REST_API_VERSION = "v1"

        fun createEndpoint(uri: String): String {
            require(uri.trim() != String.empty()) { outputMessage("Endpoint should not be empty --> $uri") }
            require(uri.startsWith(REST_API_SEPARATOR)) { outputMessage("Endpoint should start with $REST_API_SEPARATOR --> $uri") }
            require(uri.endsWith(REST_API_SEPARATOR).not()) { outputMessage("Endpoint should not end with $REST_API_SEPARATOR --> $uri") }

            return "$REST_API_SEPARATOR$REST_API_URI" +
                    "$REST_API_SEPARATOR$REST_API_VERSION" +
                    uri.toLowerCase().trim()
        }

        fun rootUri() = "$REST_API_SEPARATOR$REST_API_URI"
        fun name() = REST_API_NAME
        fun version() = REST_API_VERSION

        private fun outputMessage(message: String) = println(message)
    }
}