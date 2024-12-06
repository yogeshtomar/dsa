package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RearangeArrayElementsBySign {
    public static List<Integer> rearrageBySign(List<Integer> list) {
        List<Integer> ans = new ArrayList<>(Collections.nCopies(list.size(), 0));
        int posIndex = 0; int negativeIndex = 1;
        for (int i = 0 ; i < list.size(); i++) {
            if (list.get(i) < 0 && negativeIndex < list.size()) {
                ans.set(negativeIndex, list.get(i));
                negativeIndex += 2;
            }
            else {
                ans.set(posIndex, list.get(i));
                posIndex += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, -4, -5));
        System.out.println("List after rearranging:");
        list = rearrageBySign(list);
        System.out.println(list.toString());
    }
}
