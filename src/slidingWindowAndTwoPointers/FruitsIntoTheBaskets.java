package slidingWindowAndTwoPointers;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoTheBaskets {
    public static int totalFruits(int[] trees) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxFruits = 0;
        while (right < trees.length) {
            int fruit = trees[right];
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);

            while (map.size() > 2) {
                int oddFruit = trees[left];
                map.put(oddFruit, map.get(oddFruit) -1);
                if (map.get(oddFruit) == 0) {
                    map.remove(oddFruit);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 1, 3, 4, 3, 4};
        System.out.println("Max Fruits that can be picked: " + totalFruits(fruits));
    }
}
