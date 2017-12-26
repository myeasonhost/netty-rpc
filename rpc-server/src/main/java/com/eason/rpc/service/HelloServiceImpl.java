package com.eason.rpc.service;


import com.eason.rpc.common.annotation.ServiceExporter;
import com.eason.rpc.service.demo.HelloService;


@ServiceExporter(name = "helloServiceImpl")
public class HelloServiceImpl implements HelloService{
    public String say(String name) {
        return "say:"+name;
    }

    public String hi(String name) {
        return "hi:"+name;
    }
}
