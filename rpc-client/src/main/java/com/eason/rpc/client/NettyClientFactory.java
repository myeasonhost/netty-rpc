package com.eason.rpc.client;

import java.net.InetSocketAddress;
import java.util.concurrent.ConcurrentHashMap;

public class NettyClientFactory {

    private static ConcurrentHashMap<Class<?>,NettyClient> serviceClientMap = new ConcurrentHashMap<Class<?>, NettyClient>();

    public static NettyClient get(String host,int port,Class<?> targetInterface){
        NettyClient client = serviceClientMap.get(targetInterface);
        if(client != null && !client.isClosed()){
            return client;
        }
        //connect
        NettyClient newClient = new NettyClient();
        //TODO get from service registry
//        String host = "127.0.0.1";
//        int port = 9090;
        newClient.connect(new InetSocketAddress(host,port));
        serviceClientMap.putIfAbsent(targetInterface,newClient);
        return newClient;
    }


}
