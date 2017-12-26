package com.eason.rpc.common.exception;


public class ServerException extends RpcException{

    private String traceId;

    public ServerException(String traceId, final Exception cause) {
        super(cause);
        this.traceId = traceId;
    }

    public ServerException(Exception cause) {
        super(cause);
    }

    public ServerException(String message) {
        super(message);
    }

    public String getTraceId() {
        return traceId;
    }
}
