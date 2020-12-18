package io.kimmking.rpcfx.client.netty;

import com.alibaba.fastjson.JSON;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.CountDownLatch;

public class RpcClientSyncHandler extends SimpleChannelInboundHandler<RpcProtocol> {

    private CountDownLatch latch;
    private RpcfxResponse response;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RpcProtocol msg) {

        // 将 RpcResponse字符串 反序列化成 RpcResponse对象
        RpcfxResponse rpcfxResponse = JSON.parseObject(new String(msg.getContent(), CharsetUtil.UTF_8), RpcfxResponse.class);
        response = rpcfxResponse;
        latch.countDown();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    RpcfxResponse getResponse() throws InterruptedException {
        latch.await();
        return response;
    }
}
