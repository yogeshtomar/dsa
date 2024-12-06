package binarySearchTrees;

public class DeleteNodeInBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.data == key){
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {
            if (root.data > key) {
                if (root.left != null && root.left.data == key) {
                    root.left = helper(root.left);
                    break;
                }
                else {
                    root = root.left;
                }
            }
            else {
                if (root.right != null && root.right.data == key) {
                    root.right = helper(root.right);
                    break;
                }
                else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    private TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        else if (root.right == null) {
            return root.left;
        }
        else {
            TreeNode rightChild = root.right;
            TreeNode lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    private TreeNode findLastRight(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
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
        int key = 5;
        DeleteNodeInBST sol = new DeleteNodeInBST();
        root = sol.deleteNode(root, key);
        System.out.println("BST after deletion of key: " + key);
        BTreePrinter.printBinaryTree(root);
    }
}
