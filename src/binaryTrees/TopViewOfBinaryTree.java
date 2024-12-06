package binaryTrees;

import java.util.*;

public class TopViewOfBinaryTree {
    public static List<Integer> getTopViewOfBinaryTree(TreeNode root) {
        List<Integer> topView = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> current = queue.poll();
            TreeNode temp = current.getNode();
            int horizontalDistance = current.getValue();
            map.putIfAbsent(horizontalDistance, temp.data);
            if (temp.left != null) {
                queue.add(new Pair<>(temp.left, horizontalDistance - 1));
            }
            if (temp.right != null) {
                queue.add(new Pair<>(temp.right, horizontalDistance + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            topView.add(entry.getValue());
        }
        return topView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        List<Integer> topView = getTopViewOfBinaryTree(root);
        System.out.println(topView.toString());
    }
}
