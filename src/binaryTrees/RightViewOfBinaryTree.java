package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBinaryTree {
    public static List<Integer> getRightViewOfBinaryTree(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();
        if (root == null) {
            return rightView;
        }
        recursionRight(root, 0, rightView);
        return rightView;
    }

    private static void recursionRight(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        if (result.size() == level) {
            result.add(node.data);

            recursionRight(node.right, level+1, result);
            recursionRight(node.left, level+1, result);
        }
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

        List<Integer> rightView = getRightViewOfBinaryTree(root);
        System.out.println(rightView.toString());
    }
}
