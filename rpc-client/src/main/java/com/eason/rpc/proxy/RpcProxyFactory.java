package com.eason.rpc.proxy;

import com.eason.rpc.client.NettyClient;
import com.eason.rpc.client.NettyClientFactory;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

@Component
public class RpcProxyFactory {

    public <T> T proxyBean(String host, int port, Class<?> targetInterface, long timeoutInMillis) {
        NettyClient client = NettyClientFactory.get(host, port, targetInterface);
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{targetInterface}, new RpcProxy(client, Pair.of(timeoutInMillis, TimeUnit.MILLISECONDS)));
    }
}
