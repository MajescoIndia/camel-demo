package com.example;

import com.example.proxy.ErrorPropagationProxy;
import com.example.proxy.MybatisDemoProcProxy;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class CamelDemoApplication {
	@Autowired CamelContext camelContext;

	public static void main(String[] args) {
		SpringApplication.run(CamelDemoApplication.class, args);
	}

	@Bean
	ErrorPropagationProxy registerErrorPropagationProxy() throws Exception {
		ErrorPropagationProxy proxy = new ProxyBuilder(camelContext)
				.endpoint("direct:errorPropagationDirectEndpoint")
				.build(ErrorPropagationProxy.class);
		return proxy;
	}

    @Bean
    MybatisDemoProcProxy registerMybatisDemoProcProxy() throws Exception {
        MybatisDemoProcProxy proxy = new ProxyBuilder(camelContext)
                .endpoint("direct:mybatisDemoClassCodeProc")
                .build(MybatisDemoProcProxy.class);
        return proxy;
    }
}
