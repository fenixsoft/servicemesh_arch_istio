package com.github.fenixsoft.bookstore.infrastructure.configuration;

import com.github.fenixsoft.bookstore.domain.security.AccountServiceClient;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs2.JAXRS2Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 设置交互为JAX-RS2方式，实际Feign中的JAX-RS2指的是1.1
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/18 22:38
 **/
@Configuration
public class FeignConfiguration {

    @Bean
    public Contract feignJAXRS2Contract() {
        return new JAXRS2Contract();
    }

    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder();
    }

    @Bean
    public Encoder feignEncoder() {
        return new JacksonEncoder();
    }

    @Bean
    public AccountServiceClient buildAccountServiceClient() {
        return Feign.builder().contract(feignJAXRS2Contract()).decoder(feignDecoder()).encoder(feignEncoder()).target(AccountServiceClient.class, "http://account");
    }

}
