package com.github.fenixsoft.bookstore.paymnet;

import com.github.fenixsoft.bookstore.paymnet.domain.client.ProductServiceClient;
import feign.Feign;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.jaxrs2.JAXRS2Contract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.github.fenixsoft.bookstore"})
public class PaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Bean
    public ProductServiceClient buildProductServiceClient() {
        return Feign.builder()
                .client(new ApacheHttpClient())
                .contract(new JAXRS2Contract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(ProductServiceClient.class, "http://warehouse");
    }
}
