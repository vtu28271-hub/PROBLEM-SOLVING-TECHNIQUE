import java.util.Scanner;
public class Task7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int evenSum = 0;
        int oddSum = 0;

        while (number > 0) {
            int digit = number % 10;

            if (digit % 2 == 0) {
                evenSum = evenSum + digit;
            } else {
                oddSum = oddSum + digit;
            }

            number = number / 10;
        }

        System.out.println("Even digits sum: " + evenSum);
        System.out.println("Odd digits sum: " + oddSum);
    }
}