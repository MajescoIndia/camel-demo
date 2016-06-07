package com.example.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author Biplab Nayak [Created on 6/7/2016].
 */
@Component
public class EIPRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:testDelayedRoute").routeId("delayedRoute")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String body = exchange.getIn().getBody(String.class);
                        exchange.getIn().setBody(StringUtils.swapCase(body));
                    }
                }).id("swapCase")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        exchange.getIn().setBody(exchange.getIn().getBody(String.class).toLowerCase());
                    }
                }).id("lowerCase");

    }
}
