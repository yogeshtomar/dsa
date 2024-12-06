package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public int maximumWidthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int width = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int mmin = queue.peek().getValue();
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {

                Pair<TreeNode, Integer> current = queue.poll();
                int currentIndex = current.getValue() - mmin;
                TreeNode node = current.getNode();

                if (i == 0) {
                    first = currentIndex;
                }

                if (i == size - 1) {
                    last = currentIndex;
                }

                if (node.left != null) {
                    queue.add(new Pair<>(node.left, currentIndex * 2 + 1));
                }

                if (node.right != null) {
                    queue.add(new Pair<>(node.right, currentIndex * 2 + 2));
                }

                width = Math.max(width, last - first + 1);
            }
        }
        return width;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        MaximumWidthOfBinaryTree obj = new MaximumWidthOfBinaryTree();
        int maxWidth = obj.maximumWidthOfBinaryTree(root);

        System.out.println("Maximum width of the Binary Tree is : " + maxWidth);
    }
}
