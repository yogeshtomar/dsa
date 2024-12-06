package binaryHeaps;

import java.util.*;

public class MaxSumCombinations {
    public List<Integer> maxSumCombination(List<Integer> A, List<Integer> B, int C) {
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Set<String> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        maxHeap.add(new int[] {A.get(0) + B.get(0), 0, 0});
        visited.add(0 + "," + 0);

        for (int i = 0; i < C && !maxHeap.isEmpty(); i++) {
            int[] top = maxHeap.poll();
            int sum = top[0];
            int idxA = top[1];
            int idxB = top[2];

            result.add(sum);
            if (idxA + 1 < A.size() && !visited.contains(idxA + 1 + "," + idxB)){
                maxHeap.add(new int[] {A.get(idxA + 1) + B.get(idxB), idxA + 1, idxB});
                visited.add( (idxA + 1 ) + "," + idxB);
            }

            if (idxB + 1 < B.size() && !visited.contains(idxB + 1 + "," + idxA)) {
                maxHeap.add(new int[] {A.get(idxA) + B.get(idxB) + 1, idxA, idxB + 1});
                visited.add(idxA + "," + (idxB+1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSumCombinations sol = new MaxSumCombinations();
        List<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 2, 3));
        List<Integer> B = new ArrayList<>(Arrays.asList(2, 5, 1, 6));
        int C = 4;

        List<Integer> result = sol.maxSumCombination(A, B, C);
        System.out.println("Top " + C + " maximum sum combinations: " + result);
    }
}
