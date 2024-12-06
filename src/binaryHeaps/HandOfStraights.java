package binaryHeaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HandOfStraights {
    public boolean isStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

        Map<Integer, Integer> cardCount = new HashMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        Queue<Integer> minHeap = new PriorityQueue<>(cardCount.keySet());
        while (!minHeap.isEmpty()) {
            int start = minHeap.peek();

            for (int i = start; i < start + W; i++) {
                if (!cardCount.containsKey(i)) {
                    return false;
                }

                cardCount.put(i, cardCount.get(i) - 1);
                if (cardCount.get(i) == 0) {
                    cardCount.remove(i);
                    minHeap.remove(i);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HandOfStraights solver = new HandOfStraights();

        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int W = 3;
        System.out.println("Can the hand be arranged into groups of W consecutive cards? " + solver.isStraightHand(hand, W));
    }
}
