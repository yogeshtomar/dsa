package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextGreaterPermutation {
    public static List<Integer> nextGreaterPermutation(List<Integer> num) {
        int n = num.size();
        int index = -1;
        for (int i = n-2; i >= 0; i--) {
            if (num.get(i) < num.get(i+1)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            Collections.reverse(num);
            return num;
        }
        for (int i = n-1; i > index; i--) {
            if (num.get(i) > num.get(index)) {
                int temp = num.get(i);
                num.set(i, num.get(index));
                num.set(index, temp);
                break;
            }
        }
        List<Integer> sublist = num.subList(index + 1, n);
        Collections.reverse(sublist);
        return num;
    }

    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>(List.of(2, 1, 5, 4, 3, 0, 0));
        List<Integer> ans = nextGreaterPermutation(num);
        System.out.println("The Next Greater Permutation is : " + ans.toString());
    }
}
