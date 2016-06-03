package com.example.routes;

import com.example.exceptions.IrrecoverableException;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.net.SocketTimeoutException;

/**
 * @author Biplab Nayak [Created on 6/3/2016].
 */
@Component
public class ErrorPropagationRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("direct:errorPropagationDirectEndpoint").routeId("errorPropagationRoute")
                .doTry()
                .to("direct:throwException")
                .doCatch(SocketTimeoutException.class)
                .throwException(IrrecoverableException.class, "Irrecoverable Exception occured. ${exception.stacktrace}")
                .doCatch(Exception.class)
                .throwException(IrrecoverableException.class, "Some Error Occurred.")
                .end();

        from("direct:throwException")
                .throwException(SocketTimeoutException.class, "Just For testing");
    }
}
