
import java.util.HashMap;
import java.util.Map;

class degree of array {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            count.put(num, count.getOrDefault(num, 0) + 1);
            first.putIfAbsent(num, i);
            last.put(num, i);
        }

        int degree = 0;
        for (int freq : count.values()) {
            degree = Math.max(degree, freq);
        }

        int result = nums.length;
        for (int num : count.keySet()) {
            if (count.get(num) == degree) {
                int length = last.get(num) - first.get(num) + 1;
                result = Math.min(result, length);
            }
        }

        return result;
    }
}
