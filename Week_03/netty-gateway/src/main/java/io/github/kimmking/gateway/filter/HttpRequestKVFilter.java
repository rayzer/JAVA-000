package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestKVFilter implements HttpRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestKVFilter.class);

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        HttpHeaders h = fullRequest.headers();
        h.set("nio", "ray");
    }
}
