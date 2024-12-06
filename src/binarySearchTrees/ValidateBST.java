package binarySearchTrees;

public class ValidateBST {
    public static boolean isValidBST(TreeNode root){
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data >= max || root.data <= min) {
            return false;
        }

        return isValidBST(root.left, min, root.data)
                && isValidBST(root.right, root.data, max);
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

        BTreePrinter.printBinaryTree(root);
        System.out.println("is Valid BST: " + isValidBST(root));
    }
}
