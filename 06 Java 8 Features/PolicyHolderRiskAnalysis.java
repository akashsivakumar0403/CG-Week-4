import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return String.format("ID = %s, Name = %s, Risk Score = %.2f", holderId, name, riskScore);
    }
}

public class PolicyHolderRiskAnalysis {

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("PH001", "Ruchi", 65, "Life", 40000),
                new PolicyHolder("PH002", "Vandit", 70, "Life", 35000),
                new PolicyHolder("PH003", "Ami", 58, "Health", 30000),
                new PolicyHolder("PH004", "Bhadrik", 75, "Life", 30000),
                new PolicyHolder("PH005", "Yash", 62, "Life", 20000),
                new PolicyHolder("PH006", "Harsh", 80, "Life", 10000),
                new PolicyHolder("PH007", "Meet", 68, "Auto", 25000)
        );

        List<PolicyHolder> filtered = holders.stream().filter(ph -> ph.policyType.equalsIgnoreCase("Life") && ph.age > 60).collect(Collectors.toList());

        List<RiskAssessment> assessments = filtered.stream().map(ph -> new RiskAssessment(ph.holderId, ph.name, ph.premiumAmount / ph.age)).collect(Collectors.toList());

        assessments.sort(Comparator.comparingDouble(r -> -r.riskScore));

        Map<String, List<RiskAssessment>> categorized = assessments.stream().collect(Collectors.groupingBy(r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"));

        System.out.println("High Risk Policyholders:");
        categorized.getOrDefault("High Risk", Collections.emptyList()).forEach(System.out::println);

        System.out.println("Low Risk Policyholders:");
        categorized.getOrDefault("Low Risk", Collections.emptyList()).forEach(System.out::println);
    }
}
