package binarySearch.bsOnAnswers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PaintersPartition {
    public static int findLargestMinDistance(List<Integer> boards, int k) {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        while (low <= high) {
            int mid = low + (high - low)/2;
            int painters = countPainters(boards, mid);
            if (painters > k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countPainters(List<Integer> boards, int time) {
        int n = boards.size();
        int painters = 1;
        long boardsPainters = 0;
        for (int i = 0; i < n; i++) {
            if (boardsPainters + boards.get(i) <= time) {
                boardsPainters += boards.get(i);
            }
            else {
                painters++;
                boardsPainters = boards.get(i);
            }
        }
        return  painters;
    }

    public static void main(String[] args) {
        List<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int k = 2;
        int ans = findLargestMinDistance(boards, k);
        System.out.println("The answer is: " + ans);
    }
}
