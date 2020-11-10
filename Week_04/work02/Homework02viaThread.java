public class Homework02viaThread {
    
    public static void main(String[] args) throws Exception{
        long start=System.currentTimeMillis();
        SingleThread s = new SingleThread();
        s.start();
        s.join();

        System.out.println("异步计算结果为：" + s.getResult());
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

    private static class SingleThread extends Thread {
        private int result;

        @Override
        public void run() {
            result = sum();
        }

        public int getResult() {
            return result;
        }
    }
}
