package binarySearchTrees;

public class KthLargestAndSmallestElement {
    private static int count = 0;
    private static int result = Integer.MIN_VALUE;
    public static int findKthSmallest(TreeNode root, int k) {
        count = 0;
        result = Integer.MIN_VALUE;
        inOrder(root, k);
        return result;
    }

    public static int findKthLargest(TreeNode root, int k) {
        count = 0;
        result = Integer.MIN_VALUE;
        reverseOrder(root, k);
        return result;
    }

    private static void reverseOrder(TreeNode root, int k) {
        if (root == null) return;
        reverseOrder(root.right, k);
        count++;
        if (count == k) {
            result = root.data;
            return;
        }
        reverseOrder(root.left, k);
    }

    private static void inOrder(TreeNode root, int k) {
        if (root == null) return;

        inOrder(root.left, k);
        count++;
        if (count == k) {
            result = root.data;
            return;
        }
        inOrder(root.right, k);
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

        int k = 3;
        System.out.println("Binary Search Tree: ");
        BTreePrinter.printBinaryTree(root);
        System.out.println("Kth smallest : " + findKthSmallest(root, k));
        System.out.println("Kth largest : " + findKthLargest(root, k));
    }
}
