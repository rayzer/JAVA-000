package io.kimmking.rpcfx.server;

import org.springframework.http.HttpStatus;

public class RpcfxException extends RuntimeException{
    private HttpStatus statusCode;
    private String message;

    public RpcfxException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
