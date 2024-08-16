package edu.mylearning.calculator.svc.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/calculator/basic")
public class BasicCalculatorResource {
    private static final Logger LOG = LoggerFactory.getLogger(BasicCalculatorResource.class);

    @GET
    @Path("add/{firstNumber}/{secondNumber}")
    public Response getSum(@PathParam("firstNumber") Long firstNumber,
                           @PathParam("secondNumber") Long secondNumber){
        LOG.info("Adding numbers {}  and {}", firstNumber, secondNumber);
        Long sum = firstNumber + secondNumber;
        return Response.ok()
                .entity(sum)
                .build();
    }
}
