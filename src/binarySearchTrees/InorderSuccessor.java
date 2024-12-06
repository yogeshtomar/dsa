package binarySearchTrees;

import com.sun.source.tree.Tree;

public class InorderSuccessor {
    TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.data < root.data) {
                successor = root; // Potential successor
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
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
        TreeNode node = root.right.left;
        InorderSuccessor sol = new InorderSuccessor();
        TreeNode successor = sol.inorderSuccessor(root, node);
        System.out.println("Inorder successor for val : " + node.data + " is " + successor.data);
    }
}
