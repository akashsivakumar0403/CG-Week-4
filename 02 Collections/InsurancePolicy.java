import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getPolicyholderName() { return policyholderName; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }
    public double getPremiumAmount() { return premiumAmount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "Policy {" +
                "policyNumber = '" + policyNumber + '\'' +
                ", name = '" + policyholderName + '\'' +
                ", expiryDate = " + expiryDate +
                ", coverage = '" + coverageType + '\'' +
                ", premium = " + premiumAmount +
                '}';
    }
}

public class InsurancePolicy {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();
    private Map<String, Integer> policyCount = new HashMap<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
        policyCount.put(policy.getPolicyNumber(), policyCount.getOrDefault(policy.getPolicyNumber(), 0) + 1);
    }

    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        for (Policy p : hashSet) System.out.println(p);
    }

    public void displayExpiringSoon() {
        System.out.println("Policies Expiring in 30 Days:");
        LocalDate today = LocalDate.now();
        for (Policy p : treeSet) {
            long days = ChronoUnit.DAYS.between(today, p.getExpiryDate());
            if (days >= 0 && days <= 30) {
                System.out.println(p);
            }
        }
    }

    public void displayByCoverageType(String type) {
        System.out.println("Policies with Coverage Type = " + type + ":");
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    public void displayDuplicates() {
        System.out.println("Duplicate Policies");
        for (Map.Entry<String, Integer> entry : policyCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate Policy Number = " + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        InsurancePolicy system = new InsurancePolicy();

        system.addPolicy(new Policy("P001", "Ruchi", LocalDate.now().plusDays(10), "Health", 1200.0));
        system.addPolicy(new Policy("P002", "Vandit", LocalDate.now().plusDays(40), "Auto", 900.0));
        system.addPolicy(new Policy("P003", "Ami", LocalDate.now().plusDays(25), "Home", 800.0));
        system.addPolicy(new Policy("P001", "Bhadrik", LocalDate.now().plusDays(10), "Health", 1200.0));

        system.displayAllPolicies();
        system.displayExpiringSoon();
        system.displayByCoverageType("Health");
        system.displayDuplicates();
    }
}
