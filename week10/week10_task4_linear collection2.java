
import java.util.ArrayList;
import java.util.Scanner;

public class linear colletion2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Invalid number of students.");
            sc.close();
            return;
        }
        int highest = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            int mark = sc.nextInt();
            marks.add(mark);

            if (mark > highest) {
                highest = mark;
            }

            sum += mark;
        }
        System.out.println("\nStudent Marks: " + marks);
        System.out.println("Highest Mark: " + highest);
        double average = (double) sum / marks.size();
        System.out.printf("Average Mark: %.2f%n", average);

        sc.close();
    }
}
