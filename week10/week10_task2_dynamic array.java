
import java.util.ArrayList;
import java.util.Scanner;

public class dynamic array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            int mark = sc.nextInt();
            marks.add(mark);
        }
        System.out.println("\nStudent Marks:");
        for (int i = 0; i < marks.size(); i++) {
            System.out.println("Student " + (i + 1) + ": " + marks.get(i));
        }

        sc.close();
    }
}
