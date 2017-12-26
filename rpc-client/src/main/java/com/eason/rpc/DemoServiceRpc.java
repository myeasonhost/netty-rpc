package com.eason.rpc;

import com.eason.rpc.common.annotation.ClientExporter;
import com.eason.rpc.common.annotation.ClientService;
import com.eason.rpc.proxy.RpcProxyFactory;
import com.eason.rpc.service.demo.HelloService;
import com.eason.rpc.service.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@ClientExporter("demoServiceRpc")
public class DemoServiceRpc  {

    @ClientService(address = "127.0.0.1:9090")
    HelloService helloService;

    @ClientService(address = "127.0.0.1:9090")
    UserService userService;


    public void run(String s) throws Exception {
        System.out.println(helloService.hi(s));
        System.out.println(userService.login(s));
    }
}
