import java.util.*;

public class Main {

    public static List<Integer> gradingStudents(List<Integer> grades) {

        List<Integer> result = new ArrayList<>();

        for (int grade : grades) {

            // If grade is less than 38, don't round
            if (grade < 38) {
                result.add(grade);
            } else {

                // Find the next multiple of 5
                int nextMultiple = ((grade / 5) + 1) * 5;

                // If difference is less than 3, round up
                if (nextMultiple - grade < 3) {
                    result.add(nextMultiple);
                } else {
                    result.add(grade);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of students
        int n = sc.nextInt();

        List<Integer> grades = new ArrayList<>();

        // Read grades
        for (int i = 0; i < n; i++) {
            grades.add(sc.nextInt());
        }

        // Get rounded grades
        List<Integer> result = gradingStudents(grades);

        // Print result
        for (int grade : result) {
            System.out.println(grade);
        }

        sc.close();
    }
}
