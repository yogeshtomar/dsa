package binarySearchTrees;

public class MinMaxInBST {
    public int findMinInBST(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }

        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    public int findMaxInBST(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("BST is empty");
        }

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.left.left.left = new TreeNode(2);

        MinMaxInBST sol = new MinMaxInBST();
        System.out.println("Inorder Traversal of the Tree : ");
        root.printInorderTraversal(root);
        System.out.println("Min element : " + sol.findMinInBST(root));
        System.out.println("Max element : " + sol.findMaxInBST(root));
    }
}
