package com.eason.rpc;

import com.eason.rpc.proxy.RpcProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class DemoRpc implements CommandLineRunner {

    @Autowired
    private RpcProxyFactory rpcProxyFactory;

    @Autowired
    private DemoServiceRpc demoServiceRpc;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(rpcProxyFactory);
        demoServiceRpc.run("aaa");
    }
}
