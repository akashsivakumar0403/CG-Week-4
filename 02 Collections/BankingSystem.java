import java.util.*;

public class BankingSystem {
    private HashMap<String, Double> accounts = new HashMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAcc(String accNum, double initialBal) {
        if (!accounts.containsKey(accNum)) {
            accounts.put(accNum, initialBal);
            System.out.println("Account = " + accNum + " created with balance " + initialBal);
        } else {
            System.out.println("Account " + accNum + " already exists");
        }
    }

    public void reqWithdrawal(String accNum) {
        if (accounts.containsKey(accNum)) {
            withdrawalQueue.offer(accNum);
            System.out.println("Withdrawal request added for account = " + accNum);
        } else {
            System.out.println("Account " + accNum + " does not exist");
        }
    }

    public void processWithdrawal(double amt) {
        while (!withdrawalQueue.isEmpty()) {
            String accNum = withdrawalQueue.poll();
            double bal = accounts.get(accNum);
            if (bal >= amt) {
                accounts.put(accNum, bal - amt);
                System.out.println("Withdrawal of " + amt + " successful for account = " + accNum);
            } else {
                System.out.println("insufficient balance in account = " + accNum);
            }
        }
    }

    public void displayAccSortedByBal() {
        TreeMap<Double, List<String>> sortedByBal = new TreeMap<>();

        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            double bal = entry.getValue();
            String accNum = entry.getKey();
            sortedByBal.putIfAbsent(bal, new ArrayList<>());
            sortedByBal.get(bal).add(accNum);
        }

        System.out.println("\nAccounts sorted by balance:");
        for (Map.Entry<Double, List<String>> entry : sortedByBal.entrySet()) {
            double bal = entry.getKey();
            List<String> accList = entry.getValue();
            for (String acc : accList) {
                System.out.println("Account Num = " + acc + " -> Balance = " + bal);
            }
        }
    }

    public void displayAll() {
        System.out.println("\nAll Accounts:");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account Num = " + entry.getKey() + " -> Balance = " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAcc("ACC1001", 5000);
        bank.addAcc("ACC1002", 7000);
        bank.addAcc("ACC1003", 3000);
        bank.addAcc("ACC1004", 9000);

        bank.displayAll();

        System.out.println();
        bank.reqWithdrawal("ACC1002");
        bank.reqWithdrawal("ACC1005");

        bank.processWithdrawal(2000);

        bank.displayAll();
        bank.displayAccSortedByBal();
    }
}