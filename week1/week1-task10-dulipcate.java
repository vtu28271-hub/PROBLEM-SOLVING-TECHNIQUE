public class Main {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 20, 40, 50, 10, 30};

        System.out.println("Duplicate elements are:");

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] == numbers[j]) {

                    System.out.println(numbers[i]);
                    break;
                }
            }
        }
    }
}
