package binarySearchTrees;

public class LargestBST {
    private  int maxSize = 0;
    static class TreeInfo {
        boolean isBst;
        int size;
        int min;
        int max;

        public TreeInfo(boolean isBst, int size, int min, int max) {
            this.isBst = true;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public int largestBst(TreeNode node) {
        postorderTraversal(node);
        return maxSize;
    }

    private TreeInfo postorderTraversal(TreeNode node) {
        if (node == null) {
            return new TreeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        TreeInfo leftSubtree = postorderTraversal(node.left);
        TreeInfo rightSubtree = postorderTraversal(node.right);

        if (leftSubtree.isBst && rightSubtree.isBst &&
                node.data > leftSubtree.max && node.data < rightSubtree.min) {
            int currentSize = leftSubtree.size + rightSubtree.size + 1;
            maxSize = Math.max(maxSize, currentSize);
            int minValue = Math.min(node.data, leftSubtree.min);
            int maxValue = Math.max(node.data, rightSubtree.max);

            return new TreeInfo(true, currentSize, minValue, maxValue);
        }
        else {
            return new TreeInfo(false, Math.max(leftSubtree.size, rightSubtree.size), 0, 0);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LargestBST sol = new LargestBST();
        int largestBSTSize = sol.largestBst(root);
        BTreePrinter.printBinaryTree(root);
        System.out.println("The size of largest BST in the given Binary Tree is: " + largestBSTSize);
    }

}
