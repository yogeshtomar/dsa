package binaryTrees;

public class BalancedBinaryTree {
    private TreeNode root;
    public BalancedBinaryTree(TreeNode root) {
        this.root = root;
    }

    public boolean isBalancedTree(TreeNode root) {
        return isBalancedTreeHeight(root) != -1;
    }

    private int isBalancedTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = isBalancedTreeHeight(root.left);
        int rightHeight = isBalancedTreeHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);

        root.left = two;
        root.right = five;
        root.left.left = three;
        root.left.right = four;
        root.right.left = six;
        root.right.right = seven;
        root.right.right.left = eight;

        BalancedBinaryTree tree1 = new BalancedBinaryTree(root);
        System.out.println("Balanced Tree " + tree1.isBalancedTree(tree1.root));

        BalancedBinaryTree tree2 = new BalancedBinaryTree(root);
        root.left = two;
        root.right = four;
        root.left.left = three;
        root.left.left.left = nine;
        root.right.left = five;
        root.right.right = six;
        root.right.right.right = seven;
        root.right.right.left = eight;

        System.out.println("Balanced Tree : " + tree2.isBalancedTree(root));
    }
}
