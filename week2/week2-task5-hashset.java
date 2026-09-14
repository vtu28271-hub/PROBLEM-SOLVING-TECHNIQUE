import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        // Create HashSet
        HashSet<Integer> set = new HashSet<>();

        // Add elements
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // Duplicate - will not be added

        System.out.println("HashSet: " + set);

        // Check if element exists
        System.out.println("Contains 20: " + set.contains(20));

        // Remove element
        set.remove(10);

        System.out.println("After removing 10: " + set);

        // Size
        System.out.println("Size: " + set.size());

        // Check if empty
        System.out.println("Is empty: " + set.isEmpty());

        // Loop through HashSet
        System.out.println("Elements:");

        for (int num : set) {
            System.out.println(num);
        }

        // Clear all elements
        set.clear();

        System.out.println("After clear: " + set);
    }
}