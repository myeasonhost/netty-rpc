package com.eason.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class RpcServerApplication {

    public static void main(String[] args){
        SpringApplication.run(RpcServerApplication.class, args);
    }
}
