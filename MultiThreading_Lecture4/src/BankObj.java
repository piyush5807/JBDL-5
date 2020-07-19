public class BankObj extends Thread{

    private int account;
    private int balance;

    public BankObj(int account, int balance) {
        this.account = account;
        this.balance = balance;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
