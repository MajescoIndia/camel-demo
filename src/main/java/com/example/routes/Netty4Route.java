package com.example.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @author Biplab Nayak [Created on 6/6/2016].
 */
@Component
public class Netty4Route extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("netty4:tcp://localhost:7000?sync=true&allowDefaultCodec=false&encoder=#stringEncoder&decoder=#stringDecoder")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println();
                    }
                });
    }
}
