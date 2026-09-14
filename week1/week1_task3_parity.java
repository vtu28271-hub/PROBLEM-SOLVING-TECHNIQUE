import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class parity {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();

        while (testCases > 0) {

            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        // Sort students
        Collections.sort(studentList, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {

                // 1. CGPA - descending order
                if (s1.getCgpa() != s2.getCgpa()) {
                    return Double.compare(s2.getCgpa(), s1.getCgpa());
                }

                // 2. Name - alphabetical order
                int nameCompare =
                    s1.getFname().compareTo(s2.getFname());

                if (nameCompare != 0) {
                    return nameCompare;
                }

                // 3. ID - ascending order
                return Integer.compare(s1.getId(), s2.getId());
            }
        });

        // Print names
        for (Student st : studentList) {
            System.out.println(st.getFname());
        }

        in.close();
    }
}
