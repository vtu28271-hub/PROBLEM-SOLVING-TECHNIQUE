import java.util.*;

class nooftwodays {

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDays(date1) - toDays(date2));
    }

    private int toDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        int total = 0;

        // Add days for previous years
        for (int y = 1; y < year; y++) {
            total += isLeapYear(y) ? 366 : 365;
        }

        // Add days for previous months
        for (int m = 1; m < month; m++) {
            total += days[m - 1];
        }

        // Add leap day if applicable
        if (month > 2 && isLeapYear(year)) {
            total++;
        }

        // Add current day
        total += day;

        return total;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 ||
               (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first date (yyyy-mm-dd): ");
        String date1 = sc.nextLine();

        System.out.print("Enter second date (yyyy-mm-dd): ");
        String date2 = sc.nextLine();

        Solution obj = new Solution();

        int result = obj.daysBetweenDates(date1, date2);

        System.out.println("Number of days between dates: " + result);

        sc.close();
    }
}