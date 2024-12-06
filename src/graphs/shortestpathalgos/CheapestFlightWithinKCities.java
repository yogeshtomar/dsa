package graphs.shortestpathalgos;

import java.util.*;

public class CheapestFlightWithinKCities {

    static class Edge {
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.weight = wt;
        }
    }

    public static void buildGraph(int n, int[][] flights, List<List<Edge>> adjList) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int src = flight[0];
            int dest = flight[1];
            int weight = flight[2];
            Edge e = new Edge(src, dest, weight);

            if (adjList.get(src) == null) {
                adjList.add(src, new ArrayList<>());
            }
            adjList.get(src).add(e);
        }
    }

    static class EdgeInfo {
        int dest;
        int cost;
        int stops;

        public EdgeInfo(int dest, int cost, int stops) {
            this.dest = dest;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dest, int k ) {
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        List<List<Edge>> adjList = new ArrayList<>();
        buildGraph(n, flights, adjList);

//        Queue<EdgeInfo> minHeap = new PriorityQueue<>(new Comparator<EdgeInfo>() {
//            @Override
//            public int compare(EdgeInfo a, EdgeInfo b) {
//                return a.cost - b.cost;
//            }
//        });

        Queue<EdgeInfo> minHeap = new LinkedList<>();

        minHeap.add(new EdgeInfo(src, 0, 0));
        distance[src] = 0;

        while (!minHeap.isEmpty()) {
            EdgeInfo cur = minHeap.poll();
            if (cur.stops > k) {
                break;
            }

            for (Edge edge : adjList.get(cur.dest)) {
                int u = edge.src;
                int v = edge.dest;;
                int wt = edge.weight;

                if (cur.cost + wt < distance[v]) {
                    distance[v] = cur.cost + wt;
                    minHeap.add(new EdgeInfo(v, distance[v], cur.stops + 1));
                }
            }
        }

        return distance[dest] == Integer.MAX_VALUE ? -1 : distance[dest];
    }


    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
//        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int[][] flights = {{0,1,1}, {0,2,5}, {1, 2, 1}, {2, 3, 1}};
        System.out.println("cheapest flight : " + findCheapestPrice(n, flights, src, dst, K));

//        int N = 2, nSrc = 1, nDest = 1, nK = 1;
//        int[][] nFlights = {{1,0,5}};
//
//        System.out.println("cheapest flight : " + findCheapestPrice(N, nFlights, nSrc, nDest, nK));
    }

}