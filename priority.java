import java.util.Scanner;

public class priority {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        LocalDate obj = new LocalDate();

        String result = obj.dayOfTheWeek(day, month, year);

        System.out.println(result);

        sc.close();
    }
}

class LocalDate {

    public String dayOfTheWeek(int day, int month, int year) {

        String[] days = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
        };

        int[] monthDays = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int totalDays = 0;

        // Days from 1971 to the previous year
        for (int y = 1971; y < year; y++) {
            if (isLeapYear(y)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }

        // Days in previous months
        for (int m = 1; m < month; m++) {
            totalDays += monthDays[m - 1];

            if (m == 2 && isLeapYear(year)) {
                totalDays++;
            }
        }

        // Add current day - 1
        totalDays += day - 1;

        // January 1, 1971 was Friday (index 5)
        return days[(totalDays + 5) % 7];
    }

    public boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}