package com.eason.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RpcServerApplication {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(RpcServerApplication.class);
        app.setWebEnvironment(false);
        app.run(args);
    }
}
