import java.util.Arrays;

class Solution {

    public void moveZeroes(int[] nums) {
        int j = 0;

        // Move non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
        }

        // Fill remaining positions with zero
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        Solution obj = new Solution();

        obj.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }
}