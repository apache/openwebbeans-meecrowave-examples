package com.superbiz.jaxrs

import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("helloKotlin")
@ApplicationScoped
class HelloFromKotlinEndpoint {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun sayHi(): String {
        return "Hello World from Kotlin"
    }
}
