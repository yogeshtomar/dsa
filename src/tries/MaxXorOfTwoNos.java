package tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxXorOfTwoNos {
    private XorTrieNode root;
    public MaxXorOfTwoNos() {
        root = new XorTrieNode();
    }

    public void insert(int num) {
        XorTrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new XorTrieNode());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        XorTrieNode node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum |= (1 << i);
                node = node.get(1- bit);
            }
            else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }

    public int getMaxXor(int m, int n, List<Integer> arr1, List<Integer> arr2) {
        for (int item : arr1) {
            insert(item);
        }
        int maxI = 0;
        for (int item : arr2){
            maxI = Math.max(maxI, getMax(item));
        }
        return maxI;
    }

    public static void main(String[] args) {
        MaxXorOfTwoNos sol = new MaxXorOfTwoNos();
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(3, 10, 5, 25, 2));
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(8, 1, 2, 12, 7));
        int m = arr1.size();
        int n = arr2.size();
        System.out.println("Array1 : " + arr1.toString());
        System.out.println("Array2 : " + arr2.toString());

        System.out.println("Max XOR Value: " + sol.getMaxXor(m, n, arr1, arr2));

    }
}
