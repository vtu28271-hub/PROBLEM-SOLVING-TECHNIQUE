import java.util.*;

public class square{
    public static void main(String[] args) {

        int[] num = {2, 4, 6, 8, 10};

        for (int i = 0; i < num.length; i++) {
            num[i] = num[i] * num[i];
        }

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}