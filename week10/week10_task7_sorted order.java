
import java.util.TreeSet;
import java.util.Scanner;

public class sorted order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> marks = new TreeSet<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            int mark = sc.nextInt();
            marks.add(mark);
        }

        System.out.println("\nUnique Marks in Ascending Order:");
        for (int mark : marks) {
            System.out.println(mark);
        }

        sc.close();
    }
}
