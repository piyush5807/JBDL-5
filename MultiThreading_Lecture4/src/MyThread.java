public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("I am in thread " + currentThread().getName());
    }
}
