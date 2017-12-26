package com.eason.rpc.service;


import com.eason.rpc.common.annotation.ServiceExporter;
import com.eason.rpc.service.demo.UserService;


@ServiceExporter(name = "userServiceImpl")
public class UserServiceImpl implements UserService {
    @Override
    public String login(String name) {
        if ("eason".equals(name)){
            return "登陆成功";
        }
        return "登陆失败";
    }
}
