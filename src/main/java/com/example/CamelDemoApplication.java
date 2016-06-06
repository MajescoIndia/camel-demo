package com.example;

import com.example.proxy.ErrorPropagationProxy;
import com.example.proxy.MybatisDemoProcProxy;
import com.example.proxy.MybatisDemoProxy;
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

	public static void main(String[] args) {
		SpringApplication.run(CamelDemoApplication.class, args);
	}

}
