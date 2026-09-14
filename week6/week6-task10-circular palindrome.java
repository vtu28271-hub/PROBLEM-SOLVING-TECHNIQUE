import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int totalSum = sumOfLastDigits(num1, num2);

        System.out.println("Sum of the last digits: " + totalSum);

        scanner.close();
    }

    public static int sumOfLastDigits(int input1, int input2) {
        int lastDigit1 = Math.abs(input1 % 10);
        int lastDigit2 = Math.abs(input2 % 10);

        return lastDigit1 + lastDigit2;
    }
}
