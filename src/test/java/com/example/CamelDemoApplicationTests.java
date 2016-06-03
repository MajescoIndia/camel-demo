package com.example;

import com.example.proxy.ErrorPropagationProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CamelDemoApplication.class)
@WebAppConfiguration
public class CamelDemoApplicationTests {

    @Autowired
	ErrorPropagationProxy propagationProxy;

	@Test
	public void contextLoads() {
        try {
            propagationProxy.test();
        } catch (Exception e) {
            System.out.println();
        }
	}

}
