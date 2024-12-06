package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsDifferentSizes {
    public static List<Integer> rearrangeElementsBySign(List<Integer> list) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i : list) {
            if (i > 0) {
                pos.add(i);
            }
            else {
                neg.add(i);
            }
        }

        if (pos.size() < neg.size()) {
            for (int i = 0; i < pos.size(); i++) {
                list.set(2 * i, pos.get(i));
                list.set(2 * i + 1,  neg.get(i));
            }
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                list.set(index, neg.get(i));
                index++;
            }
        }
        else {
            for (int i = 0; i < neg.size(); i++) {
                list.set(2 * i, pos.get(i));
                list.set(2 * i + 1, neg.get(i));
            }
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                list.set(index, pos.get(i));
                index++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5, 3, 4));

        ArrayList<Integer> ans = (ArrayList<Integer>) rearrangeElementsBySign(A);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
