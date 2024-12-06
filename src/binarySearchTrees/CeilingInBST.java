package binarySearchTrees;

public class CeilingInBST {
    public int ceiling(TreeNode root, int key) {
        if (root == null) {
            throw new IllegalArgumentException("Root of Tree can not be null.");
        }
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }

            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
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

        System.out.println("BST :");
        BTreePrinter.printBinaryTree(root);
        int key = 8;
        CeilingInBST sol = new CeilingInBST();
        System.out.println("Ceil of the key : " + key + " in the BST is : " + sol.ceiling(root, key));
    }
}
