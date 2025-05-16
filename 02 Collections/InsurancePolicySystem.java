import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Policy1 implements Comparable<Policy1> {
    private String policyNum;
    private String policyName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmt;

    public Policy1(String policyNum, String policyName, LocalDate expiryDate, String coverageType, double premiumAmt) {
        this.policyNum = policyNum;
        this.policyName = policyName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmt = premiumAmt;
    }

    public String getPolicyNum() { return policyNum; }
    public String getPolicyName() { return policyName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmt() { return premiumAmt; }

    public int compareTo(Policy1 other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    public String toString() {
        return "Policy {" +
                "policyNumber = '" + policyNum + '\'' +
                ", policyholderName = '" + policyName + '\'' +
                ", expiryDate = " + expiryDate +
                ", coverageType = '" + coverageType + '\'' +
                ", premiumAmount = " + premiumAmt +
                '}';
    }
}

public class InsurancePolicySystem {
    private Map<String, Policy1> hashMapPolicies = new HashMap<>();
    private Map<String, Policy1> linkedHashMapPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy1>> treeMapPolicies = new TreeMap<>();

    public void addPolicy(Policy1 policy) {
        hashMapPolicies.put(policy.getPolicyNum(), policy);
        linkedHashMapPolicies.put(policy.getPolicyNum(), policy);
        treeMapPolicies.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public Policy1 getPolicyNumber(String policyNum) {
        return hashMapPolicies.get(policyNum);
    }

    public List<Policy1> listPoliciesExpiringInNext30Days() {
        List<Policy1> expiringSoon = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate cutOffDate = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy1>> entry : treeMapPolicies.subMap(today, true, cutOffDate, true).entrySet()) {
            expiringSoon.addAll(entry.getValue());
        }

        return expiringSoon;
    }

    public List<Policy1> listPoliciesByHolder(String holderName) {
        List<Policy1> result = new ArrayList<>();
        for (Policy1 policy : linkedHashMapPolicies.values()) {
            if (policy.getPolicyName().equalsIgnoreCase(holderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, Policy1>> iterator = hashMapPolicies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy1> entry = iterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                iterator.remove();
                linkedHashMapPolicies.remove(entry.getKey());
                treeMapPolicies.get(entry.getValue().getExpiryDate()).remove(entry.getValue());
            }
        }
        treeMapPolicies.entrySet().removeIf(entry -> entry.getValue().isEmpty());
    }

    public static void main(String[] args) {
        InsurancePolicySystem manager = new InsurancePolicySystem();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        manager.addPolicy(new Policy1("P001", "Ruchi", LocalDate.parse("2025-05-20", formatter), "Health", 1200.50));
        manager.addPolicy(new Policy1("P002", "Vandit", LocalDate.parse("2025-05-10", formatter), "Auto", 800.00));
        manager.addPolicy(new Policy1("P003", "Ami", LocalDate.parse("2025-06-01", formatter), "Home", 1500.00));
        manager.addPolicy(new Policy1("P004", "Bhadrik", LocalDate.parse("2025-04-28", formatter), "Health", 1300.00));

        System.out.println("Retrieve Policy P002 = ");
        System.out.println(manager.getPolicyNumber("P002"));
        System.out.println();

        System.out.println("Policies expiring in the next 30 days:");
        List<Policy1> expiringPolicies = manager.listPoliciesExpiringInNext30Days();
        for (Policy1 policy : expiringPolicies) {
            System.out.println(policy);
        }
        System.out.println();

        System.out.println("Policies for Ruchi:");
        List<Policy1> ruchiPolicies = manager.listPoliciesByHolder("Ruchi");
        for (Policy1 policy : ruchiPolicies) {
            System.out.println(policy);
        }
        System.out.println();

        System.out.println("Removing expired policies...");
        manager.removeExpiredPolicies();
        System.out.println("Remaining Policies:");
        for (Policy1 policy : manager.linkedHashMapPolicies.values()) {
            System.out.println(policy);
        }
    }
}
