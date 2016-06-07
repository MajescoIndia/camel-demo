package com.example.routes;

import com.example.AbstractCamelSpringInitializer;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.ModelCamelContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Biplab Nayak [Created on 6/7/2016].
 */
public class EIPRoutesTest extends AbstractCamelSpringInitializer {
    @Autowired
    ProducerTemplate producerTemplate;

    @Autowired
    ModelCamelContext camelContext;

    @Test
    public void testConfig() {
        Assert.assertNotNull(camelContext);
        Assert.assertNotNull(producerTemplate);
    }

    @Before
    public void setup() throws Exception {
        camelContext.getRouteDefinition("delayedRoute").adviceWith(camelContext, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                replaceFromWith("seda:start");
                weaveAddLast().to("mock:result");
                weaveById("lowerCase").before().to("mock:Intermidiate");
            }
        });
        camelContext.start();
    }

    @Test
    public void testDelayedRoute() throws InterruptedException {
        MockEndpoint mockResult = camelContext.getEndpoint("mock:result", MockEndpoint.class);
        MockEndpoint mockIntermediate = camelContext.getEndpoint("mock:Intermidiate", MockEndpoint.class);

        mockIntermediate.expectedBodiesReceived("bIPLAB nAYAK");
        mockResult.expectedBodiesReceived("biplab nayak");

        producerTemplate.sendBody("seda:start", "Biplab Nayak");
        mockIntermediate.assertIsSatisfied();
        mockResult.assertIsSatisfied();

    }
}
