package graphs.mst;

import java.util.ArrayList;
import java.util.List;

public class UnionBySize {
    List<Integer> rank;
    List<Integer> parnet;
    List<Integer> size;

    public UnionBySize(int n) {
        rank = new ArrayList<>();
        parnet = new ArrayList<>();
        size = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parnet.add(i, i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parnet.get(node)) {
            return node;
        }
        int ultimateParent = findParent(parnet.get(node));
        parnet.set(node, ultimateParent);
        return parnet.get(node);
    }

    public void unionByRank(int u, int v) {
        int ultimateParent_U = findParent(u);
        int ultimateParent_V = findParent(v);
        if (ultimateParent_U == ultimateParent_V) {
            return;
        }
        if (rank.get(ultimateParent_V) < rank.get(ultimateParent_U)) {
            parnet.set(ultimateParent_V, ultimateParent_U);
        }
        else if (rank.get(ultimateParent_U) < rank.get(ultimateParent_V)) {
            parnet.set(ultimateParent_U, ultimateParent_V);
        }
        else {
            parnet.set(ultimateParent_V, ultimateParent_U);
            int rankU = rank.get(ultimateParent_U);
            rank.set(ultimateParent_U, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ultimateParent_U = findParent(u);
        int ultimateParent_V = findParent(v);
        if (ultimateParent_U == ultimateParent_V) {
            return;
        }
        if (size.get(ultimateParent_U) < size.get(ultimateParent_V)) {
            parnet.set(ultimateParent_U, ultimateParent_V);
            size.set(ultimateParent_V, size.get(ultimateParent_V) + size.get(ultimateParent_U));
        }
        else {
            parnet.set(ultimateParent_V, ultimateParent_U);
            size.set(ultimateParent_U, size.get(ultimateParent_U) + size.get(ultimateParent_V));
        }
    }

    public static void main(String[] args) {
        UnionBySize ds = new UnionBySize(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);

        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same Parent");
        } else {
            System.out.println("Not Same");
        }

        ds.unionBySize(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same Parent after Union");
        } else {
            System.out.println("Not Same");
        }
    }
}
