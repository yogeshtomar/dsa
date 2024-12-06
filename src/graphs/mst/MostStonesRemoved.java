package graphs.mst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UnionFind {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    int count = 0;
    public UnionFind(int n) {
        count = n;
        for (int i = 0; i <=n ; i++) {
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
        if (rank.get(ultimateParent_V) < rank.get(ultimateParent_U)) {
            parent.set(ultimateParent_V, ultimateParent_U);
        }
        else if (rank.get(ultimateParent_U) < rank.get(ultimateParent_V)) {
            parent.set(ultimateParent_U, ultimateParent_V);
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
            size.set(ultimateParent_V, size.get(ultimateParent_U) + size.get(ultimateParent_V));
        }
        else {
            parent.set(ultimateParent_V, ultimateParent_U);
            size.set(ultimateParent_U, size.get(ultimateParent_U) + size.get(ultimateParent_V));
        }
        count--;
    }
}

public class MostStonesRemoved {
    public boolean isConnected(int[] u, int[] v) {
        return (u[0] == v[0] || u[1] == v[1]);
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isConnected(stones[i], stones[j])) {
                    uf.unionBySize(i, j);
                }
            }
        }
        return n - uf.count;
    }
}
