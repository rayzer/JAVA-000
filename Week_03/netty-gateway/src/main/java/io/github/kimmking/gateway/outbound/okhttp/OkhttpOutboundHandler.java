package io.github.kimmking.gateway.outbound.okhttp;

import io.github.kimmking.gateway.outbound.OutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class OkhttpOutboundHandler  implements OutboundHandler {
    @Override
    public void handle(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {

    }
}
