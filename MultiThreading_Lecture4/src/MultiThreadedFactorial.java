import java.math.BigInteger;

public class MultiThreadedFactorial {

    public static void main(String[] args) throws InterruptedException {

        int[]arr = {10000, 20000, 30000, 60000, 7700, 4000, 5000, 7000, 150000, 400000, 50000, 70000, 4000000, 30000};

        long start = System.currentTimeMillis();

        MyThread[]threads = new MyThread[arr.length];
        for(int i=0;i<threads.length;i++){
            threads[i] = new MyThread(arr[i]);
            threads[i].start();
        }

        // t1, t2, ... t10
        for(int i=0;i<threads.length;i++){

            // blocking call
            threads[i].join(100);
            System.out.println(threads[i].result);
        }

        System.out.println(System.currentTimeMillis() - start);

    }

    private static class MyThread extends Thread{

        int num;
        BigInteger result;

        public MyThread(int num) {
            this.num = num;
            result = BigInteger.valueOf(1);
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            calculate();
        }

        public void calculate(){

            for(int i=2;i<=this.num;i++){
                result = result.multiply(BigInteger.valueOf(i));
            }

        }
    }
}
