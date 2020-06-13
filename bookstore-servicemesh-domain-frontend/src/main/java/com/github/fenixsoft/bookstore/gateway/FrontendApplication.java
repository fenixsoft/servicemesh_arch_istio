package com.github.fenixsoft.bookstore.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringCloud Netflix全家桶的服务API网关
 *
 * @author icyfenix@gmail.com
 * @date 2020/4/17 17:50
 **/
@SpringBootApplication
public class FrontendApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class, args);
    }
}
