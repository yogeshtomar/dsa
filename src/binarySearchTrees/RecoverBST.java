package binarySearchTrees;

public class RecoverBST {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (first == null && prev.data >= node.data) {
            first = prev;
        }
        if (first != null && prev.data >= node.data) {
            second = node;
        }
        prev = node;
        inorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        System.out.println("BST before recovery");
        BTreePrinter.printBinaryTree(root);

        RecoverBST sol = new RecoverBST();
        System.out.println("BST after recovery");
        sol.recoverTree(root);
        BTreePrinter.printBinaryTree(root);
    }
}
