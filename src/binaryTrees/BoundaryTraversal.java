package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> boundary) {
        TreeNode current = root.left;
        while (current != null) {
            if (!isLeafNode(current)) {
                boundary.add(current.data);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    private void addRightBoundary(TreeNode root, List<Integer> boundary) {
        TreeNode current = root.right;
        List<Integer> temp = new ArrayList<>();

        while (current != null) {
            if (!isLeafNode(current)){
                temp.add(current.data);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        boundary.addAll(temp.reversed());
    }

    private void addLeaves(TreeNode root, List<Integer> leaves) {
        if (isLeafNode(root)) {
            leaves.add(root.data);
            return;
        }
        if (root.left != null) {
            addLeaves(root.left, leaves);
        }
        if (root.right != null) {
            addLeaves(root.right, leaves);
        }
    }

    public List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        if (!isLeafNode(root)) {
            result.add(root.data);
        }

        addLeftBoundary(root, result);
        addLeaves(root, result);
        addRightBoundary(root, result);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BoundaryTraversal obj = new BoundaryTraversal();
        System.out.println("Boundary Traversal : " + obj.boundaryTraversal(root).toString());
    }
}
