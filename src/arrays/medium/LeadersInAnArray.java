package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {
    public static List<Integer> leadersInAnArray(int[] array) {
        int n = array.length;
        List<Integer> ans = new ArrayList<>();
        ans.add(array[n-1]);
        int max = array[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (array[i] > array[i+1]) {
                ans.add(array[i]);
                max = array[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array=  {10, 22, 12, 3, 0, 6};
        List<Integer> ans = leadersInAnArray(array);
        ans.sort(Collections.reverseOrder());
        System.out.println(ans.toString());
    }
}
