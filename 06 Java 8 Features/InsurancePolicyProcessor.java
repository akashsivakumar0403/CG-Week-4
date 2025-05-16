import java.util.*;
import java.util.stream.*;

class InsurancePolicy {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy Number = " + policyNumber + ", Holder = " + holderName + ", Premium = " + premiumAmount;
    }
}

public class InsurancePolicyProcessor {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
                new InsurancePolicy("P001", "Ruchi", 1200),
                new InsurancePolicy("P002", "Vandit", 1500),
                new InsurancePolicy("P003", "Ami", 800),
                new InsurancePolicy("P004", "Bhadrik", 2000),
                new InsurancePolicy("P005", "Yash", 2500),
                new InsurancePolicy("P006", "Harsh", 2200)
        );

        List<InsurancePolicy> filteredPolicies = policies.stream().filter(policy -> policy.getPremiumAmount() > 1200).collect(Collectors.toList());
        System.out.println("Policies with Premium > 1200 = " + filteredPolicies);

        List<InsurancePolicy> sortedByName = policies.stream().sorted(Comparator.comparing(InsurancePolicy::getHolderName)).collect(Collectors.toList());
        System.out.println("Policies sorted by Holder Name = " + sortedByName);

        double totalPremium = policies.stream().mapToDouble(InsurancePolicy::getPremiumAmount).sum();
        System.out.println("Total Premium Amount = " + totalPremium);

        System.out.println("Policy Details = ");
        policies.forEach(policy -> System.out.println(policy));

        List<InsurancePolicy> premiumRangePolicies = policies.stream().filter(policy -> policy.getPremiumAmount() > 1000 && policy.getPremiumAmount() < 2000).collect(Collectors.toList());
        System.out.println("Policies with Premium between 1000 and 2000 = " + premiumRangePolicies);

        Optional<InsurancePolicy> highestPremiumPolicy = policies.stream().max(Comparator.comparing(InsurancePolicy::getPremiumAmount));
        highestPremiumPolicy.ifPresent(policy -> System.out.println("Policy with Highest Premium = " + policy));

        Map<Character, List<InsurancePolicy>> groupedByInitial = policies.stream().collect(Collectors.groupingBy(policy -> policy.getHolderName().charAt(0)));
        System.out.println("Policies Grouped by Holder Name Initial = " + groupedByInitial);

        double averagePremium = policies.stream().mapToDouble(InsurancePolicy::getPremiumAmount).average().orElse(0);
        System.out.println("Average Premium Amount = " + averagePremium);

        List<InsurancePolicy> sortedByPremium = policies.stream().sorted(Comparator.comparingDouble(InsurancePolicy::getPremiumAmount)).collect(Collectors.toList());
        System.out.println("Policies sorted by Premium Amount = ");
        sortedByPremium.forEach(policy -> System.out.println(policy));

        boolean anyPolicyExceeds = policies.stream().anyMatch(policy -> policy.getPremiumAmount() > 2000);
        System.out.println("Any policy with premium > 2000 = " + anyPolicyExceeds);

        Map<String, Long> premiumRangeCount = policies.stream().collect(Collectors.groupingBy(policy -> {
                    if (policy.getPremiumAmount() <= 1000) return "0-1000";
                    if (policy.getPremiumAmount() <= 2000) return "1001-2000";
                    return "> 2000";
                }, Collectors.counting()));
        System.out.println("Count of Policies in Each Premium Range = " + premiumRangeCount);

        Set<String> uniqueHolderNames = policies.stream().map(InsurancePolicy::getHolderName).collect(Collectors.toSet());
        System.out.println("Unique Holder Names = " + uniqueHolderNames);

        List<InsurancePolicy> policiesByNameSubstring = policies.stream().filter(policy -> policy.getHolderName().contains("Smith")).collect(Collectors.toList());
        System.out.println("Policies with Holder Name containing 'Ruchi' = " + policiesByNameSubstring);

        Map<String, Double> policyMap = policies.stream().collect(Collectors.toMap(InsurancePolicy::getPolicyNumber, InsurancePolicy::getPremiumAmount));
        System.out.println("Map of Policy Numbers to Premium Amounts = " + policyMap);
    }
}
