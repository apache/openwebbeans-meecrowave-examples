package com.superbiz.jaxrs

import org.apache.meecrowave.Meecrowave
import org.apache.meecrowave.junit.MonoMeecrowave
import org.apache.meecrowave.testing.ConfigurationInject
import org.junit.runner.RunWith
import javax.ws.rs.client.ClientBuilder
import javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE
import kotlin.test.Test
import kotlin.test.assertEquals

@RunWith(MonoMeecrowave.Runner::class)
class HelloFromKotlinEndpointTest {

    @ConfigurationInject
    private lateinit var configuration: Meecrowave.Builder

    @Test
    fun `client answeres on path "hello"`() {
        val client = ClientBuilder.newClient()
        try {
            assertEquals("Hello World from Kotlin", client.target("http://localhost:" + configuration.httpPort)
                    .path("/helloKotlin")
                    .request(APPLICATION_JSON_TYPE)
                    .get(String::class.java))
        } finally {
            client.close()
        }
    }
}
