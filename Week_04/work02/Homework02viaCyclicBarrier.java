import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Homework02viaCyclicBarrier {
    
    public static void main(String[] args) throws Exception {
        long start=System.currentTimeMillis();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        calcRunnable c = new calcRunnable(cyclicBarrier);
        new Thread(c).start();

        cyclicBarrier.await();

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

    private static class calcRunnable implements Runnable {
        private int result;
        private CyclicBarrier barrier;

        public calcRunnable(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                result = sum();
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        public int getResult() {
            return result;
        }
    }
}
