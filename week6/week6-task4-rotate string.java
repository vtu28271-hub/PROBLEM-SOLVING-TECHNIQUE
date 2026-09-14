import java.util.*;

public class Main {

    public static boolean rotateString(String s, String goal) {

        // Different lengths cannot be rotations
        if (s.length() != goal.length()) {
            return false;
        }

        // Empty strings
        if (s.length() == 0) {
            return true;
        }

        // A rotation of s must exist inside s + s
        String doubled = s + s;

        return doubled.contains(goal);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter goal string: ");
        String goal = sc.nextLine();

        boolean result = rotateString(s, goal);

        System.out.println("Output: " + result);

        sc.close();
    }
}