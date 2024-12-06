package binarySearchTrees;


public class InsertIntoBST {
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        TreeNode current = root;
        while (true) {
            if (current.data <= key) {
                if (current.right != null) {
                    current = current.right;
                }
                else {
                    current.right = new TreeNode(key);
                    break;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                }
                else {
                    current.left = new TreeNode(key);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);

        int key = 5;
        System.out.println("BST");
        BTreePrinter.printBinaryTree(root);
        InsertIntoBST sol = new InsertIntoBST();
        root = sol.insert(root, key);
        System.out.println("BST After Insertion");
        BTreePrinter.printBinaryTree(root);
    }
}
