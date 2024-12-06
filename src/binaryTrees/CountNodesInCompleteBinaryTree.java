package binaryTrees;

public class CountNodesInCompleteBinaryTree {
    private int findLeftSubtreeHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int findRightSubtreeHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = findLeftSubtreeHeight(root);
        int rightHeight = findRightSubtreeHeight(root);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.right.left = new TreeNode(7);

        CountNodesInCompleteBinaryTree solution = new CountNodesInCompleteBinaryTree();

        int totalNodes = solution.countNodes(root);
        System.out.println("Total No of nodes in the complete binary tree : " + totalNodes);
    }
}
