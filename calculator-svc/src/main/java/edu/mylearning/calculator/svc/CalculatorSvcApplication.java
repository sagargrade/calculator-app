package edu.mylearning.calculator.svc;

import edu.mylearning.calculator.svc.resources.BasicCalculatorResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

public class CalculatorSvcApplication {
    private static final Logger LOG = LoggerFactory.getLogger(CalculatorSvcApplication.class);
    private static final String BASE_URI = "http://localhost:8080";

    public static void main(String[] args) {
        LOG.info("***** Calculator Service Application Started *****");
        BasicCalculatorResource basicCalculatorResource = new BasicCalculatorResource();
        // Set up the resource configuration and register the resources
        ResourceConfig resourceConfig = new ResourceConfig().register(basicCalculatorResource);
        // Start Grizzly HTTP server
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
        // Add shutdown hook to stop the server gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            LOG.info("***** Shutting down HTTP Server *****");
            server.shutdown();
            LOG.info("***** Server shut down *****");
        }));

        try {
            LOG.info("***** Press CTRL+C to stop the server *****");
            // Keeps the main thread alive to keep the server running
            Thread.currentThread().join();
        } catch (InterruptedException ex){
            LOG.error("***** Server interrupted *****", ex);
            Thread.currentThread().interrupt();
        }
    }
}
