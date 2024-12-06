package binarySearchTrees;

public class FloorInBST {
    public int floor(TreeNode root, int key) {
        if (root == null) {
            throw new IllegalArgumentException("Root of the Tree can not be null");
        }

        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            }
            if (key > root.data) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
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

        System.out.println("Inorder Traversal of the BST :");
        root.printInorderTraversal(root);
        int key = 8;
        FloorInBST sol = new FloorInBST();
        System.out.println("Ceil of the key : " + key + " in the BST is : " + sol.floor(root, key));
    }
}
