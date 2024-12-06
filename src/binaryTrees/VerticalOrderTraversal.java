package binaryTrees;

import java.util.*;

class Tuple {
    TreeNode node;
    int vertical;
    int level;

    public Tuple(TreeNode node, int vertical, int level) {
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
public class VerticalOrderTraversal {
     public List<List<Integer>> verticalTraversal(TreeNode root) {
         Map<Integer, Map<Integer, TreeSet<Integer>>> map = new TreeMap<>();
         Queue<Tuple> queue = new LinkedList<>();
         queue.add(new Tuple(root, 0, 0));
         while (!queue.isEmpty()) {
             Tuple currentTuple = queue.poll();
             TreeNode current = currentTuple.node;
             int vertical = currentTuple.vertical;
             int level = currentTuple.level;

             map.computeIfAbsent(vertical, k -> new TreeMap<>())
                     .computeIfAbsent(level, k -> new TreeSet<>())
                     .add(current.data);

             if (current.left != null) {
                 queue.add(new Tuple(current.left, vertical-1, level+1));
             }

             if (current.right != null) {
                 queue.add(new Tuple(current.right, vertical+1, level+1));
             }
         }
         List<List<Integer>> ans = new ArrayList<>();
         for (Map.Entry<Integer, Map<Integer, TreeSet<Integer>>> entry : map.entrySet()) {
             List<Integer> col = new ArrayList<>();
             for (TreeSet<Integer> set : entry.getValue().values()) {
                 col.addAll(set);
             }
             ans.add(col);
         }
         return ans;
     }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        VerticalOrderTraversal obj = new VerticalOrderTraversal();
        List<List<Integer>> ans = obj.verticalTraversal(root);
        for (List<Integer> vertical : ans) {
            System.out.println(vertical.toString());
        }
    }
}
