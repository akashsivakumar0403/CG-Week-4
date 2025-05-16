import java.util.*;
import java.util.stream.*;

class Sale {
    String productID;
    int quantity;
    double price;

    public Sale(String productID, int quantity, double price) {
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public double getRevenue() {
        return quantity * price;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}

class ProductSales {
    String productID;
    double totalRevenue;

    public ProductSales(String productID, double totalRevenue) {
        this.productID = productID;
        this.totalRevenue = totalRevenue;
    }

    public String toString() {
        return productID + " -> Revenue = " + String.format("%.2f", totalRevenue);
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}

public class SalesAnalyzer {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P001", 5, 100.0),
                new Sale("P002", 15, 120.0),
                new Sale("P003", 8, 90.0),
                new Sale("P004", 25, 60.0),
                new Sale("P005", 12, 110.0),
                new Sale("P006", 30, 70.0),
                new Sale("P007", 10, 130.0),
                new Sale("P008", 20, 80.0)
        );

        List<Sale> filteredSales = sales.stream().filter(s -> s.getQuantity() > 10).collect(Collectors.toList());
        List<ProductSales> productSalesList = filteredSales.stream().map(s -> new ProductSales(s.getProductID(), s.getQuantity() * s.getPrice())).collect(Collectors.toList());

        productSalesList.sort(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed());

        List<ProductSales> top5 = productSalesList.stream().limit(5).collect(Collectors.toList());

        System.out.println("Top 5 Products by Revenue:");
        top5.forEach(System.out::println);
    }
}
