import java.util.function.Function;

public class CircleArea {
    public static void main(String[] args) {
        Function<Double, Double> areaFunction = radius -> Math.PI * radius * radius;

        double radius = 5.0;
        double area = areaFunction.apply(radius);

        System.out.println("Area = " + area);
    }
}
