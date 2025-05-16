import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    LocalDate claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount, LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }
}

class PolicyStats {
    String policyNumber;
    double totalAmount;
    double averageAmount;

    public PolicyStats(String policyNumber, double totalAmount, double averageAmount) {
        this.policyNumber = policyNumber;
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return "Policy = " + policyNumber + ", Total = " + totalAmount + ", Average = " + averageAmount;
    }
}

public class ClaimsAnalyzer {

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C001", "P1001", 8000, LocalDate.of(2024, 3, 15), "Approved"),
                new Claim("C002", "P1002", 3000, LocalDate.of(2024, 4, 1), "Rejected"),
                new Claim("C003", "P1001", 7000, LocalDate.of(2024, 3, 20), "Approved"),
                new Claim("C004", "P1003", 10000, LocalDate.of(2024, 4, 10), "Approved"),
                new Claim("C005", "P1002", 6000, LocalDate.of(2024, 4, 5), "Approved"),
                new Claim("C006", "P1004", 9000, LocalDate.of(2024, 4, 8), "Pending"),
                new Claim("C007", "P1002", 4000, LocalDate.of(2024, 4, 12), "Approved")
        );

        List<Claim> filtered = claims.stream().filter(c -> c.getStatus().equalsIgnoreCase("Approved") && c.getClaimAmount() > 5000).collect(Collectors.toList());

        Map<String, List<Claim>> grouped = filtered.stream().collect(Collectors.groupingBy(Claim::getPolicyNumber));

        List<PolicyStats> stats = grouped.entrySet().stream().map(entry -> {
                    String policyNumber = entry.getKey();
                    List<Claim> policyClaims = entry.getValue();
                    double total = policyClaims.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double average = policyClaims.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0.0);
                    return new PolicyStats(policyNumber, total, average);
                }).collect(Collectors.toList());

        List<PolicyStats> top3 = stats.stream().sorted(Comparator.comparingDouble(ps -> -ps.totalAmount)).limit(3).collect(Collectors.toList());

        System.out.println("Top 3 Policies with Highest Total Claims:");
        top3.forEach(System.out::println);
    }
}
