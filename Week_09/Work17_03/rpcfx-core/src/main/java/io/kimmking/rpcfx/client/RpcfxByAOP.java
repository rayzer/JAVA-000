package io.kimmking.rpcfx.client;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import io.kimmking.rpcfx.api.RpcfxRequest;
import io.kimmking.rpcfx.api.RpcfxResponse;
import io.kimmking.rpcfx.client.netty.RpcNettyClientSync;
import io.kimmking.rpcfx.server.RpcfxException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatchers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public final class RpcfxByAOP {

    static {
        ParserConfig.getGlobalInstance().addAccept("io.kimmking");
    }

    public static <T> T create(final Class<T> serviceClass, final String url) throws Exception {

        // 0. 替换动态代理 -> AOP
       // return (T) Proxy.newProxyInstance(RpcfxByCglib.class.getClassLoader(), new Class[]{serviceClass}, new RpcfxInvocationHandler(serviceClass, url));

        // ByteBuddy 创建代理类
        return (T) new ByteBuddy().subclass(Object.class)
                .implement(serviceClass)
                .intercept(InvocationHandlerAdapter.of(new RpcfxInvocationHandler(serviceClass, url)))
                .make()
                .load(RpcfxByAOP.class.getClassLoader())
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance();
    }

    public static class RpcfxInvocationHandler implements InvocationHandler {

        public static final MediaType JSONTYPE = MediaType.get("application/json; charset=utf-8");

        private final Class<?> serviceClass;
        private final String url;

        public <T> RpcfxInvocationHandler(Class<T> serviceClass, String url) {
            this.serviceClass = serviceClass;
            this.url = url;
        }

        // 可以尝试，自己去写对象序列化，二进制还是文本的，，，rpcfx是xml自定义序列化、反序列化，json: code.google.com/p/rpcfx
        // int byte char float double long bool
        // [], data class

        @Override
        public Object invoke(Object proxy, Method method, Object[] params) throws Throwable {
            RpcfxRequest request = new RpcfxRequest();
            request.setServiceClass(this.serviceClass.getName());
            request.setMethod(method.getName());
            request.setParams(params);

            if (method.getName().equalsIgnoreCase("findById")) {
                System.out.println(method);
            }

//            RpcfxResponse response = post(request, url);

            RpcfxResponse response = RpcNettyClientSync.getInstance().getResponse(request, url);
            // 这里判断response.status，处理异常
            // 考虑封装一个全局的RpcfxException
            if(!response.isStatus()){
                if (response.getException() instanceof RpcfxException) {
                    //处理异常
                    throw response.getException();
                }else {
                    //to do something
                }
            }

            return JSON.parse(response.getResult().toString());
        }

        private RpcfxResponse post(RpcfxRequest req, String url) throws IOException {
            String reqJson = JSON.toJSONString(req);
            System.out.println("req json: " + reqJson);

            // 1.可以复用client
            // 2.尝试使用httpclient或者netty client
            OkHttpClient client = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(url)
                    .post(RequestBody.create(JSONTYPE, reqJson))
                    .build();
            String respJson = Objects.requireNonNull(client.newCall(request).execute().body()).string();

            System.out.println("resp json: " + respJson);

            return JSON.parseObject(respJson, RpcfxResponse.class);
        }
    }

}
