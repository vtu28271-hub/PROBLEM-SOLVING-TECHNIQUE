import java.util.*;

class Product {
    int id;
    String name;
    int stock;
    double price;

    Product(int id, String name, int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }
}

public class ProductInventoryLowStockAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, Product> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            int stock = sc.nextInt();
            double price = sc.nextDouble();

            map.put(id, new Product(id, name, stock, price));
        }

        // Update stock after sales
        int sales = sc.nextInt();

        for (int i = 0; i < sales; i++) {
            int id = sc.nextInt();
            int quantity = sc.nextInt();

            if (map.containsKey(id)) {
                Product p = map.get(id);

                if (quantity >= 0 && quantity <= p.stock) {
                    p.stock -= quantity;
                }
            }
        }

        // Find low-stock products
        int threshold = sc.nextInt();

        System.out.println("Low Stock Products:");

        for (Product p : map.values()) {
            if (p.stock < threshold) {
                System.out.println(
                    p.id + " " + p.name + " " + p.stock
                );
            }
        }

        // Sort products by remaining stock
        ArrayList<Product> list =
            new ArrayList<>(map.values());

        list.sort((a, b) -> {
            if (a.stock != b.stock) {
                return Integer.compare(a.stock, b.stock);
            }

            return Integer.compare(a.id, b.id);
        });

        System.out.println("Products Sorted by Stock:");

        for (Product p : list) {
            System.out.println(
                p.id + " " + p.name + " " +
                p.stock + " " + p.price
            );
        }

        // Search product using ID
        int searchId = sc.nextInt();

        if (map.containsKey(searchId)) {
            Product p = map.get(searchId);

            System.out.println("Product Found:");
            System.out.println(
                p.name + " " + p.stock + " " + p.price
            );
        } else {
            System.out.println("Product Not Found");
        }
    }
}