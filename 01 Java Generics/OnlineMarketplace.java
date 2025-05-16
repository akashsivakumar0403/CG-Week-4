import java.util.*;

interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Book";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadget";
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public T getCategory() { return category; }

    public String toString() {
        return category.getCategoryName() + " - " + name + " = INR " + price;
    }
}

class MarketUtils {
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
        System.out.println("Applied " + percentage + "% discount to " + product.getName());
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Effective Java", 450.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Shirt", 300.0, new ClothingCategory());
        Product<GadgetCategory> laptop = new Product<>("Laptop", 55000.0, new GadgetCategory());

        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(laptop);

        System.out.println("Original Prices:");
        catalog.forEach(System.out::println);

        MarketUtils.applyDiscount(book, 10);
        MarketUtils.applyDiscount(shirt, 15);
        MarketUtils.applyDiscount(laptop, 25);

        System.out.println("After Discounts:");
        catalog.forEach(System.out::println);
    }
}
