import java.util.*;

public class Main {

    public static int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // 1. Ignore leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        int sign = 1;

        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        // 3. Convert digits
        long result = 0;

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {

            int digit = s.charAt(i) - '0';

            result = result * 10 + digit;

            // 4. Check overflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (result * sign);
    }

    public static void main(String[] args) {

        String s = "42";

        int result = myAtoi(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}