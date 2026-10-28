
import java.util.HashSet;
import java.util.Scanner;

public class common subjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<String> student1 = new HashSet<>();
        HashSet<String> student2 = new HashSet<>();

        System.out.print("Enter number of subjects for Student 1: ");
        int n1 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n1; i++) {
            System.out.print("Enter subject: ");
            student1.add(sc.nextLine());
        }

        System.out.print("Enter number of subjects for Student 2: ");
        int n2 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n2; i++) {
            System.out.print("Enter subject: ");
            student2.add(sc.nextLine());
        }

        // Find common subjects
        student1.retainAll(student2);

        System.out.println("\nCommon Subjects: " + student1);

        sc.close();
    }
}
