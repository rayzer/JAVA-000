package io.github.kimmking.gateway.outbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface OutboundHandler {
    void handle(FullHttpRequest fullRequest, ChannelHandlerContext ctx);
}
