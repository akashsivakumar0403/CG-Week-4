import java.util.*;

public class ShoppingCart {
    private HashMap<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cartItems = new LinkedHashMap<>();

    public ShoppingCart() {
        productPrices.put("Apple", 30.0);
        productPrices.put("Banana", 20.0);
        productPrices.put("Orange", 25.0);
        productPrices.put("Milk", 30.0);
        productPrices.put("Bread", 50.0);
    }

    public void addItemToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
            System.out.println("Added " + quantity + " " + product + "(s) to the cart");
        } else {
            System.out.println("Product " + product + " is not available");
        }
    }

    public void removeItemFromCart(String product) {
        if (cartItems.containsKey(product)) {
            cartItems.remove(product);
            System.out.println("Removed " + product + " from the cart");
        } else {
            System.out.println("Product " + product + " is not in the cart");
        }
    }

    public void displayItemsInCart() {
        System.out.println("\nItems in cart:");
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey() + " -> Quantity = " + entry.getValue() + " | Price per unit = " + productPrices.get(entry.getKey()));
        }
    }

    public void displayItemsSortedByPrice() {
        System.out.println("\nItems Sorted By Price:");
        TreeMap<String, Double> sortedItemsByPrice = new TreeMap<>((product1, product2) -> {
            double price1 = productPrices.get(product1);
            double price2 = productPrices.get(product2);
            return Double.compare(price1, price2);
        });

        for (String product : productPrices.keySet()) {
            sortedItemsByPrice.put(product, productPrices.get(product));
        }

        for (Map.Entry<String, Double> entry : sortedItemsByPrice.entrySet()) {
            System.out.println(entry.getKey() + " ->  Price = " + entry.getValue());
        }
    }

    public void calcTotal() {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            total += productPrices.get(product) * quantity;
        }
        System.out.println("\nTotal cost of items in cart = " + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItemToCart("Apple", 3);
        cart.addItemToCart("Banana", 2);
        cart.addItemToCart("Milk", 1);
        cart.addItemToCart("Bread", 1);

        cart.displayItemsInCart();
        cart.displayItemsSortedByPrice();
        cart.calcTotal();

        cart.removeItemFromCart("Banana");

        cart.displayItemsInCart();
    }
}
