package binaryTrees;

public class HeightOfBinaryTree {
    private TreeNode root;
    public HeightOfBinaryTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public int maxDepthOfTree(TreeNode root) {
        if (root == null) return 0;
        int lh = maxDepthOfTree(root.left);
        int rh = maxDepthOfTree(root.right);

        return 1 + Math.max(lh, rh);
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

        root.left = two;
        root.right = five;
        root.left.left = three;
        root.left.right = four;
        root.right.left = six;
        root.right.right = seven;
        root.right.right.left = eight;

        HeightOfBinaryTree tree = new HeightOfBinaryTree(root);

        System.out.println("Height of Binary Tree : " + tree.maxDepthOfTree(tree.getRoot()));
    }
}
