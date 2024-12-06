package binaryHeaps;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> tasksCount = new HashMap<>();
        for (char task : tasks) {
            tasksCount.put(task, tasksCount.getOrDefault(task, 0) + 1);
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        maxHeap.addAll(tasksCount.values());

        int intervals = 0;

        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = 0;
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                    cycle++;
                }
            }

            for (int count : temp) {
                if (count - 1 > 0) {
                    maxHeap.add(count - 1);
                }
            }

            intervals += maxHeap.isEmpty() ? cycle : (n+1);
        }
        return intervals;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println("Minimum intervals needed: " + scheduler.leastInterval(tasks, n));
    }
}
