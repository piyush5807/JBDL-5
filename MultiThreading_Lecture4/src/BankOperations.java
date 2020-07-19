public class BankOperations {

    public static void main(String[] args) throws InterruptedException {

        BankObj obj1 = new BankObj(1, 200);
        BankObj obj2 = new BankObj(2, 100);

        MyThread[] threads = new MyThread[6];
        threads[0] = new MyThread(obj1, true, 100);
        threads[1] = new MyThread(obj1, false, 150);
        threads[2] = new MyThread(obj1, true, 50);

        // 200

        threads[3] = new MyThread(obj2, false, 50);
        threads[4] = new MyThread(obj2, true, 200);
        threads[5] = new MyThread(obj2, false, 100);

        // 150

        for(int i=0;i<6;i++){
            threads[i].start();
        }

        for(int i=0;i<6;i++){
            threads[i].join();
        }

        System.out.println("balance for obj1 " + obj1.getBalance());
        System.out.println("balance for obj2 " + obj2.getBalance());


    }

    private static class MyThread extends Thread{

        private BankObj bankObj;
        boolean isDeposit;
        private int amount;

        public MyThread(BankObj bankObj, boolean isDeposit, int amount) {
            this.bankObj = bankObj;
            this.isDeposit = isDeposit;
            this.amount = amount;
        }

        @Override
        public void run() {
            if(this.isDeposit){
                try {
                    deposit();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    withdraw();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void deposit() throws InterruptedException {
            synchronized (this.bankObj) {
                System.out.println("In deposit function, obj name : " + this.bankObj + " , thread is " + currentThread().getName());
                Thread.sleep(3000);
                int prev_bal = this.bankObj.getBalance();
                int new_bal = prev_bal + this.amount;
                this.bankObj.setBalance(new_bal);
            }
        }

        private synchronized void withdraw() throws InterruptedException {

            synchronized (this.bankObj) {
                System.out.println("In withdraw function, obj name : " + this.bankObj + " , thread is " + currentThread().getName());
                Thread.sleep(3000);
                int prev_bal = this.bankObj.getBalance();
                int new_bal = prev_bal - this.amount;
                this.bankObj.setBalance(new_bal);
            }
        }
    }
}
