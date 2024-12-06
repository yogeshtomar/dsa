package graphs.mst;

import java.util.ArrayList;
import java.util.List;

public class NoOfOperationsToMakeNetworkConnected {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    int count;

    public NoOfOperationsToMakeNetworkConnected(int n) {
        count = n;
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ultimateParent_U = findParent(u);
        int ultimateParent_V = findParent(v);
        if (ultimateParent_U == ultimateParent_V) {
            return;
        }
        if (rank.get(ultimateParent_U) < rank.get(ultimateParent_V)) {
            parent.set(ultimateParent_U, ultimateParent_V);
        }
        else if (rank.get(ultimateParent_V) < rank.get(ultimateParent_U)) {
            parent.set(ultimateParent_V, ultimateParent_U);
        }
        else {
            parent.set(ultimateParent_V, ultimateParent_U);
            int rankU = rank.get(ultimateParent_U);
            rank.set(ultimateParent_U, rankU + 1);
        }
        count--;
    }

    public void unionBySize(int u, int v) {
        int ultimateParent_U = findParent(u);
        int ultimateParent_V = findParent(v);
        if (ultimateParent_U == ultimateParent_V) {
            return;
        }
        if (size.get(ultimateParent_U) < size.get(ultimateParent_V)) {
            parent.set(ultimateParent_U, ultimateParent_V);
            size.set(ultimateParent_V, size.get(ultimateParent_V) + size.get(ultimateParent_U));
        }
        else {
            parent.set(ultimateParent_V, ultimateParent_U);
            size.set(ultimateParent_U, size.get(ultimateParent_U) + size.get(ultimateParent_V));
        }
        count--;
    }

    int getCount() {
        return count;
    }

    public int makeConnected(int n, int[][] connections) {
        NoOfOperationsToMakeNetworkConnected ds = new NoOfOperationsToMakeNetworkConnected(n);
        int m = connections.length;
        for (int[] c : connections) {
            ds.unionByRank(c[0], c[1]);
        }
        return connections.length < n-1 ? -1 : ds.getCount() - 1;
    }

    public int makeConnected2(int n, int[][] connected) {
        UnionBySize us = new UnionBySize(n);
        int countExtras = 0;
        int m = connected.length;

        for (int i = 0; i < m; i++){
            int u = connected[i][0];
            int v = connected[i][1];
            if (us.findParent(u) == us.findParent(v)) {
                countExtras++;
            } else {
                us.unionBySize(u, v);
            }
        }
        int componentsToConnect = 0;
        for (int i = 0; i < n; i++) {
            if (us.parnet.get(i) == i) {
                componentsToConnect++;
            }
        }
        int ans = componentsToConnect - 1;
        return countExtras >= ans ? ans : -1;
    }

    public static void main(String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        NoOfOperationsToMakeNetworkConnected unionFind = new NoOfOperationsToMakeNetworkConnected(V);
        System.out.println("The number of operations needed : " + unionFind.makeConnected(V, edge));

        System.out.println(unionFind.makeConnected2(V, edge));
    }
}
