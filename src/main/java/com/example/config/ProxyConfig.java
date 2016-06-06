package com.example.config;

import com.example.proxy.ErrorPropagationProxy;
import com.example.proxy.MybatisDemoProcProxy;
import com.example.proxy.MybatisDemoProxy;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Biplab Nayak [Created on 6/6/2016].
 */

@Configuration
public class ProxyConfig {

    @Autowired
    CamelContext camelContext;

    @Bean
    ErrorPropagationProxy registerErrorPropagationProxy() throws Exception {
        ErrorPropagationProxy proxy = new ProxyBuilder(camelContext)
                .endpoint("direct:errorPropagationDirectEndpoint")
                .build(ErrorPropagationProxy.class);
        return proxy;
    }

    @Bean
    MybatisDemoProxy registerMybatisDemoProxy() throws Exception {
        MybatisDemoProxy proxy = new ProxyBuilder(camelContext)
                .endpoint("direct:mybatisDemoSelectEmployee")
                .build(MybatisDemoProxy.class);
        return proxy;
    }

    @Bean
    MybatisDemoProcProxy registerMybatisDemoProcProxy() throws Exception {
        MybatisDemoProcProxy proxy = new ProxyBuilder(camelContext)
                .endpoint("direct:mybatisDemoMaxSalProc")
                .build(MybatisDemoProcProxy.class);
        return proxy;
    }
}
