package graphs.shortestpathalgos;

import java.util.*;

public class NoOfWaysToArriveAtADestination {
    static class Pair {
        long dest;
        long time;
        public Pair(long dest, long time) {
            this.dest = dest;
            this.time = time;
        }
    }

    public static int countPaths(int n, int[][] roads) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adjList.get(road[0]).add(new Pair((long)road[1], (long)road[2]));
            adjList.get(road[1]).add(new Pair((long)road[0], (long)road[2]));
        }
        Queue<Pair> queue = new PriorityQueue<>((Pair a, Pair b) -> Long.compare(a.time, b.time));

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        queue.add(new Pair(0, 0));
        long mod = (int) 1e9+7;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (Pair next : adjList.get((int) cur.dest)) {
                long adjNode = next.dest;
                long adjTime = next.time;

                if (cur.time + adjTime < dist[(int) adjNode]) {
                    dist[(int) adjNode] = cur.time + adjTime;
                    queue.add(new Pair(adjNode, cur.time + adjTime));
                    ways[(int) adjNode] = ways[(int) cur.dest];
                }
                else if (cur.time + adjTime == dist[(int) adjNode]) {
                    ways[(int) adjNode] = (ways[(int) adjNode] + ways[(int) cur.dest]) % mod;
                }
            }
        }
        return (int) ((int)ways[n-1] % mod);
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        int n2 = 6;
        int[][] roads2 = {{0,1,1000000000}, {0,3,1000000000},{1,3,1000000000}, {1,2,1000000000}, {1,5,1000000000}, {3,4,1000000000}, {4,5,1000000000},{2,5,1000000000}};
        System.out.println("No of Ways : " + countPaths(n2, roads2));
    }
}
