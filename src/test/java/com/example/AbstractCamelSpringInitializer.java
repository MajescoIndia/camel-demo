package com.example;

import org.apache.camel.test.spring.CamelSpringBootJUnit4ClassRunner;
import org.apache.camel.test.spring.UseAdviceWith;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;

/**
 * @author Biplab Nayak [Created on 6/7/2016].
 */

@RunWith(CamelSpringBootJUnit4ClassRunner.class)
@UseAdviceWith
@SpringBootApplication
@SpringApplicationConfiguration({CamelDemoApplication.class})
public abstract class AbstractCamelSpringInitializer {
}
