package graphs.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisjointSet {
    List<Integer> rank;
    List<Integer> parent;

    public DisjointSet(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            rank.add(i, 0);
            parent.add(i, i);
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
        else if (rank.get(ultimateParent_V) < rank.get(ultimateParent_U)) {
            parent.set(ultimateParent_V, ultimateParent_U);
        }
        else {
            parent.set(ultimateParent_U, ultimateParent_V);
            int rank_U = rank.get(ultimateParent_U);
            rank.set(ultimateParent_U, rank_U + 1);
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);

        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same Parent");
        } else {
            System.out.println("Not Same");
        }

        ds.unionByRank(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same Parent after Union");
        } else {
            System.out.println("Not Same");
        }
    }

}
