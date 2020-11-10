import java.util.concurrent.*;

public class Homework02viaThreadPool {
    
    public static void main(String[] args) throws Exception{
        long start=System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        int result = executorService.submit(() -> sum()).get();

        executorService.shutdown();
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
    
    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) {
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}
