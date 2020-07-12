public class MT {

    public static void main(String[] args) throws InterruptedException {

        MyThread obj1 = new MyThread();
//        obj1.setDaemon(true);
        obj1.start();
//        Thread.sleep(80);
        System.out.println("I am in thread " + Thread.currentThread().getName());
    }
//
    private static class MyThread extends Thread{

        @Override
        public void run() {
            System.out.println("I am in thread " + currentThread().getName());
//                  Thread.sleep(50);

                // heavy computation

                System.out.println("Let's check whether this gets printed or not");

        }
    }
}
