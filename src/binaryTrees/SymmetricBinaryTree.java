package binaryTrees;

public class SymmetricBinaryTree {
    public boolean isSymmetricBinaryTree(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.data != right.data) {
            return false;
        }

        return isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);

        SymmetricBinaryTree obj = new SymmetricBinaryTree();

        System.out.println("Is Symmetric Tree : " + obj.isSymmetricBinaryTree(root));
    }
}
