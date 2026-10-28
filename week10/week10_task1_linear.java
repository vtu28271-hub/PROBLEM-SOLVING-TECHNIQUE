import java.util.*;
class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: Rs." + price;
    }
}

class Order implements Comparable<Order> {
    int orderId;
    String productName;
    int priority;

    Order(int orderId, String productName, int priority) {
        this.orderId = orderId;
        this.productName = productName;
        this.priority = priority;
    }

    public int compareTo(Order other) {
        return Integer.compare(other.priority, this.priority);
    }

    public String toString() {
        return "Order ID: " + orderId +
               ", Product: " + productName +
               ", Priority: " + priority;
    }
}

public class linear {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(101, "Laptop", 55000));
        products.add(new Product(102, "Mobile", 20000));
        products.add(new Product(103, "Headphones", 1500));

        System.out.println("Product List:");
        for (Product p : products) {
            System.out.println(p);
        }
        HashMap<Integer, Product> productMap = new HashMap<>();

        for (Product p : products) {
            productMap.put(p.id, p);
        }
        int searchId = 102;
        System.out.println("\nSearching Product ID: " + searchId);

        if (productMap.containsKey(searchId)) {
            System.out.println(productMap.get(searchId));
        } else {
            System.out.println("Product not found");
        }
        PriorityQueue<Order> orders = new PriorityQueue<>();

        orders.add(new Order(1, "Laptop", 2));
        orders.add(new Order(2, "Mobile", 5));
        orders.add(new Order(3, "Headphones", 3));

        System.out.println("\nProcessing Orders by Priority:");
        while (!orders.isEmpty()) {
            System.out.println(orders.poll());
        }
    }
}