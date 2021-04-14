package com.fernandocejas.mandrake.backend

import com.fernandocejas.mandrake.*
import com.fernandocejas.mandrake.backend.core.extension.*
import org.amshove.kluent.*
import org.junit.*

class RestApiTest : UnitTest() {

    @Test
    fun `given an endpoint creation, when its name is in uppercase, is converted to lowercase`() {
        val endpointString = "/USERS"
        val createdEndpoint = RestApi.createEndpoint(endpointString)

        createdEndpoint shouldEqual "$REST_API_URI/users"
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given an endpoint creation, when its name is an empty string, then if fails fast`() {
        RestApi.createEndpoint(String.empty())
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given an endpoint creation, when its name does not start with a SEPARATOR, then if fails fast`() {
        RestApi.createEndpoint("users")
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given an endpoint creation, when its name ends with a SEPARATOR, then if fails fast`() {
        RestApi.createEndpoint("/users/")
    }

    @Test
    fun `given version is called, returns current rest api version`() {
        RestApi.version() shouldEqual REST_API_CURRENT_VERSION
    }

    @Test
    fun `given rootUri is called, returns the rest api root starting endpoint`() {
        RestApi.rootUri() shouldEqual REST_API_ROOT_URI
    }

    companion object {
        private const val REST_API_ROOT_URI = "/api"
        private const val REST_API_CURRENT_VERSION = "v1"
        private const val REST_API_URI = "$REST_API_ROOT_URI/$REST_API_CURRENT_VERSION"
    }
}
