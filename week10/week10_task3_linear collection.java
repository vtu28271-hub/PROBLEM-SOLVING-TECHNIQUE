
import java.util.Stack;
import java.util.Scanner;

public class linear collection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> history = new Stack<>();

        System.out.print("Enter number of pages: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter page URL: ");
            String page = sc.nextLine();
            history.push(page);
        }

        System.out.println("\nBrowser History: " + history);

        if (!history.isEmpty()) {
            System.out.println("Back button pressed.");
            System.out.println("Removed page: " + history.pop());
        }

        System.out.println("Current History: " + history);

        sc.close();
    }
}
