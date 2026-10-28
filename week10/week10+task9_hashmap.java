
import java.util.HashMap;
import java.util.Scanner;

public class hashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> students = new HashMap<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Store roll numbers and marks
        for (int i = 0; i < n; i++) {
            System.out.print("Enter roll number: ");
            int roll = sc.nextInt();

            System.out.print("Enter marks: ");
            int mark = sc.nextInt();

            students.put(roll, mark);
        }
        System.out.print("Enter roll number to search: ");
        int searchRoll = sc.nextInt();

        if (students.containsKey(searchRoll)) {
            System.out.println("Marks: " + students.get(searchRoll));
        } else {
            System.out.println("Student not found.");
        }

        sc.close();
    }
}
