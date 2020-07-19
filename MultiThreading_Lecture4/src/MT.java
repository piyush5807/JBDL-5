public class MT {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        MyThread obj1 = new MyThread();
//        obj1.setDaemon(true);
        obj1.start();

        obj1.join();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("I am in thread " + Thread.currentThread().getName());
    }
//
    private static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("I am in thread " + currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // heavy computation

                System.out.println("Let's check whether this gets printed or not");

        }
    }
}
