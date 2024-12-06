package binarySearchTrees;

import java.util.Stack;

public class TwoSumUsingBSTiterator {
    static class BSTIterator {
        private final Stack<TreeNode> stack = new Stack<>();
        private final boolean isForward;

        public BSTIterator(TreeNode root, boolean isForward) {
            this.isForward = isForward;
            pushAll(root);
        }
        private void pushAll(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = isForward ? root.left : root.right;
            }
        }
        public TreeNode next() {
            TreeNode node = stack.pop();
            if (isForward) {
                pushAll(node.right);
            }
            else {
                pushAll(node.left);
            }
            return node;
        }
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        BSTIterator leftIter = new BSTIterator(root, true);
        BSTIterator rightIter = new BSTIterator(root, false);

        TreeNode left = leftIter.next();
        TreeNode right = rightIter.next();

        while (left.data < right.data) {
            int sum = left.data + right.data;
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                left = leftIter.next();
            }
            else {
                right = rightIter.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        int k = 20;

        BTreePrinter.printBinaryTree(root);
        TwoSumUsingBSTiterator sol = new TwoSumUsingBSTiterator();
        System.out.println("Two nodes with sum = " + k + " exists : " + sol.findTarget(root, k));
    }
}
