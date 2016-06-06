package com.example.config;

import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Biplab Nayak [Created on 6/6/2016].
 */

@Configuration
public class BeanConfig {

    @Bean(name = "stringDecoder")
    public StringDecoder registerStringDecoder() {
        return new StringDecoder();
    }

    @Bean(name = "stringEncoder")
    public StringEncoder registerStringEncoder() {
        return new StringEncoder();
    }
}
