import java.util.*;

public class Main {

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        // Try every possible substring length
        for (int len = 1; len <= n / 2; len++) {

            // The substring length must divide the full string
            if (n % len != 0) {
                continue;
            }

            // Take the first substring as the pattern
            String pattern = s.substring(0, len);

            boolean valid = true;

            // Check if the pattern repeats throughout the string
            for (int i = len; i < n; i += len) {

                if (!s.substring(i, i + len).equals(pattern)) {
                    valid = false;
                    break;
                }
            }

            // Pattern repeats successfully
            if (valid) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String s = "abab";

        boolean result = repeatedSubstringPattern(s);

        System.out.println(result);
    }
}

