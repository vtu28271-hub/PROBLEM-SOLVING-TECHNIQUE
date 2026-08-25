import java.util.*;

public class Main {

    public static int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int maxSum = nums[0];
        int minSum = nums[0];

        int currentMax = 0;
        int currentMin = 0;

        for (int num : nums) {

            // Maximum subarray sum
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Minimum subarray sum
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);

            total += num;
        }

        // If all elements are negative
        if (maxSum < 0) {
            return maxSum;
        }

        // Circular maximum sum
        int circularSum = total - minSum;

        return Math.max(maxSum, circularSum);
    }

    public static void main(String[] args) {

        int[] nums = {1, -2, 3, -2};

        int result = maxSubarraySumCircular(nums);

        System.out.println("Maximum Circular Subarray Sum: " + result);
    }
}