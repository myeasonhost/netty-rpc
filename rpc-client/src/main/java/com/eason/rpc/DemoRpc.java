package com.eason.rpc;

import com.eason.rpc.common.annotation.ClientExporter;
import com.eason.rpc.common.annotation.ClientService;
import com.eason.rpc.service.demo.HelloService;
import com.eason.rpc.service.demo.UserService;
import org.springframework.boot.CommandLineRunner;

@ClientExporter
public class DemoRpc implements CommandLineRunner {

    @ClientService(address = "127.0.0.1:9090")
    HelloService helloService;

    @ClientService(address = "127.0.0.1:9090")
    UserService userService;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(helloService.hi("eason"));
        System.out.println(userService.login("eason"));
    }
}
