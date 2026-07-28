
import java.util.stream.Stream;

public class FibonacciLambda {
    public static void main(String[] args) {
        int n = 10; 
        
        long nthFibonacci = Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .limit(n + 1)                  
                .reduce((first, second) -> second)
                .map(f -> f[0])               
                .orElse(0L);

        System.out.println("The " + n + "th Fibonacci number is: " + nthFibonacci);
    }
}