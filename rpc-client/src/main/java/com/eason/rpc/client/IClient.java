package com.eason.rpc.client;

import com.eason.rpc.common.dto.RpcRequest;
import com.eason.rpc.common.dto.RpcResponse;
import org.apache.commons.lang3.tuple.Pair;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public interface IClient {
    void connect(InetSocketAddress socketAddress);
    public RpcResponse syncSend(RpcRequest request) throws InterruptedException;
    public RpcResponse asyncSend(RpcRequest request, Pair<Long, TimeUnit> timeout) throws InterruptedException;
    InetSocketAddress getRemoteAddress();
    void close();
}
