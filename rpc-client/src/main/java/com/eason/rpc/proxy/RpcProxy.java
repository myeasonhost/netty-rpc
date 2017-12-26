package com.eason.rpc.proxy;

import com.eason.rpc.client.NettyClient;
import com.eason.rpc.common.dto.RpcRequest;
import com.eason.rpc.common.dto.RpcResponse;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 利用代理优化远程调用
 * 使之像本地调用一样
 */
public class RpcProxy implements InvocationHandler {

    private NettyClient nettyClient;

    private Pair<Long,TimeUnit> timeout;

    public RpcProxy() {
    }

    public RpcProxy(NettyClient nettyClient, Pair<Long, TimeUnit> timeout) {
        this.nettyClient = nettyClient;
        this.timeout = timeout;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest request = new RpcRequest(); // 创建并初始化 RPC 请求
        request.setTraceId(UUID.randomUUID().toString());
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameterTypes(method.getParameterTypes());
        request.setParameters(args);

        RpcResponse response = null;
        if(timeout == null || timeout.getKey()==0){
            response = nettyClient.syncSend(request);
        }else{
            response = nettyClient.asyncSend(request,timeout);
        }

        if (response.isError()) {
            throw response.getError();
        } else {
            return response.getResult();
        }
    }
}
