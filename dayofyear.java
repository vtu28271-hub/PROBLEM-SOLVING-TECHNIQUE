import java.util.Scanner;

class dayofyear {

    public int dayOfYear(String date) {

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // Check leap year
        if ((year % 400 == 0) ||
            (year % 4 == 0 && year % 100 != 0)) {
            days[1] = 29;
        }

        int result = day;

        // Add days of previous months
        for (int i = 0; i < month - 1; i++) {
            result += days[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        Solution obj = new Solution();

        int result = obj.dayOfYear(date);

        System.out.println("Day of the year: " + result);

        sc.close();
    }
}