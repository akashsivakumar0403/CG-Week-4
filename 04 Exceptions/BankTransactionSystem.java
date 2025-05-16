class InsufficientBalanceEx extends Exception {
    public InsufficientBalanceEx(String msg) {
        super(msg);
    }
}

class BankAcc {
    private double balance;

    public BankAcc(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amt) throws InsufficientBalanceEx {
        if (amt < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (amt > balance) {
            throw new InsufficientBalanceEx("Insufficient balance");
        }

        balance -= amt;
        System.out.println("Withdrawal successful, new balance = " + balance);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {
        BankAcc acc = new BankAcc(1000);

        try {
            acc.withdraw(500);
            acc.withdraw(-100);
            acc.withdraw(600);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientBalanceEx e) {
            System.out.println(e.getMessage());
        }
    }
}