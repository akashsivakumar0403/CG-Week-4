import java.util.*;
import java.util.stream.*;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudStats {
    long count;
    double totalAmount;

    public FraudStats(long count, double totalAmount) {
        this.count = count;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return String.format("Fraud Count = %d, Total Fraud Amount = %.2f", count, totalAmount);
    }
}

public class FraudDetection {

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "P001", 20000, "2023-01-10", true),
                new Transaction("T002", "P001", 15000, "2023-02-10", true),
                new Transaction("T003", "P002", 3000, "2023-03-10", false),
                new Transaction("T004", "P003", 60000, "2023-04-10", true),
                new Transaction("T005", "P003", 5000, "2023-04-11", true),
                new Transaction("T006", "P003", 8000, "2023-04-12", true),
                new Transaction("T007", "P003", 20000, "2023-04-13", true),
                new Transaction("T008", "P003", 15000, "2023-04-14", true),
                new Transaction("T009", "P003", 18000, "2023-04-15", true)
        );

        List<Transaction> filtered = transactions.stream().filter(t -> t.isFraudulent && t.amount > 10000).collect(Collectors.toList());

        Map<String, FraudStats> groupedStats = filtered.stream().collect(Collectors.groupingBy(t -> t.policyNumber, Collectors.collectingAndThen(Collectors.toList(), list -> new FraudStats(list.size(), list.stream().mapToDouble(t -> t.amount).sum()))));

        System.out.println("Fraud Alerts:");
        groupedStats.forEach((policy, stats) -> {
            if (stats.count > 5 || stats.totalAmount > 50000) {
                System.out.println("Policy " + policy + " => " + stats);
            }
        });
    }
}
