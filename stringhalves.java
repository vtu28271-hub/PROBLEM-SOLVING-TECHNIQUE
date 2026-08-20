import.java.util.*;
class Solution {

    public boolean halvesAreAlike(String s) {

        int mid = s.length() / 2;
        int countA = 0;
        int countB = 0;

        // First half
        for (int i = 0; i < mid; i++) {
            char ch = s.charAt(i);

            if ("aeiouAEIOU".indexOf(ch) != -1) {
                countA++;
            }
        }

        // Second half
        for (int i = mid; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ("aeiouAEIOU".indexOf(ch) != -1) {
                countB++;
            }
        }

        return countA == countB;
    }

    // MAIN FUNCTION
    public static void main(String[] args) {

        String s = "book";

        Solution obj = new Solution();

        boolean result = obj.halvesAreAlike(s);

        System.out.println(result);
    }
}