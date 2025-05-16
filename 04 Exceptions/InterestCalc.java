public class InterestCalc {
    public static double calcInterest(double amt, double rate, int years) {
        if (amt < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return amt * rate * years / 100;
    }

    public static void main(String[] args) {
        try {
            double interest = calcInterest(10000, -5, 3);
            System.out.println("Interest = " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
