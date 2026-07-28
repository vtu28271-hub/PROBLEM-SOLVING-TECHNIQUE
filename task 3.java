import java.util.*;

public class MaximumElement {

    public static void main(String[] args) {

        int arr[] = {12, 24, 58, 96, 36};

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Maximum Element = " + max);
    }
}