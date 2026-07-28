import java.util.Arrays;

public class MaxElementFinder {

public static int findMaximum(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must contain at least one element.");
        }

        int max = arr[0];

                for (int i = 1; i < arr.length; i++) {
            
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
int[] numbers = {12, 45, 93, 7, 34, 88};
        
        System.out.println("Input Array: " + Arrays.toString(numbers));
        
        try {
            int maxVal = findMaximum(numbers);
            System.out.println("The maximum element is: " + maxVal);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}     
        
