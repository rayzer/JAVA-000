import java.util.concurrent.*;

public class Homework02viaFutureTask {
    
    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();

        FutureTaskCallable fCall = new FutureTaskCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(fCall);
        new Thread(futureTask).start();

        System.out.println("异步计算结果为："+futureTask.get());
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

    private static class FutureTaskCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return sum();
        }
    }
}
