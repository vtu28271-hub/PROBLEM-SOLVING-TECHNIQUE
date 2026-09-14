public class Main {
    public static void main(String[] args) {

        // Declare and initialize an array
        int[] numbers = {10, 20, 30, 40, 50};

        // Print the array elements
        System.out.println("Array elements:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + " = " + numbers[i]);
        }

        // Access a specific element
        System.out.println("\nFirst element: " + numbers[0]);

        // Change an element
        numbers[2] = 100;

        System.out.println("After changing the third element:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + " = " + numbers[i]);
        }

        // Enhanced for loop
        System.out.println("\nUsing enhanced for loop:");

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
