import java.util.concurrent.*;

public class Homework02viaCountDownLatch {
    
    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        calcThread c = new calcThread(countDownLatch);
        new Thread(c).start();
        countDownLatch.await();

        System.out.println("异步计算结果为："+ c.getResult());
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

    private static class calcThread implements Runnable {
        private int result;
        private CountDownLatch latch;
        public calcThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            result = sum();
            latch.countDown();
        }

        public int getResult() {
            return result;
        }
    }
}
