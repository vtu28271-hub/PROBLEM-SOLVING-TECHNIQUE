import java.util.*;

public class largestnumber {
    public static String largestNumber(int[] nums) {

        // Convert integers to strings
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Sort using custom comparator
        Arrays.sort(arr, (a, b) -> {
            return (b + a).compareTo(a + b);
        });

        // If the largest number is 0
        if (arr[0].equals("0")) {
            return "0";
        }

        // Join all strings
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int[] nums = {10, 2};

        String answer = largestNumber(nums);

        System.out.println(answer);
    }
}