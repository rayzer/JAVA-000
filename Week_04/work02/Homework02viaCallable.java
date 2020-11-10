import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Homework02viaCallable {
    
    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();

        CThread c = new CThread();
        FutureTask<Integer> futureTask = new FutureTask<>(c);
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

    private static class CThread implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return sum();
        }
    }
}
