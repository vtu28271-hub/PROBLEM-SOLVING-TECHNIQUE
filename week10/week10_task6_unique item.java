
import java.util.LinkedHashSet;
import java.util.Scanner;

public class unique item {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<String> items = new LinkedHashSet<>();

        System.out.print("Enter number of items purchased: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item " + (i + 1) + ": ");
            String item = sc.nextLine();
            items.add(item);
        }

        System.out.println("\nUnique Items Purchased:");
        for (String item : items) {
            System.out.println(item);
        }

        sc.close();
    }
}
