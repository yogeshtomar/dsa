package binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class TwoSumInBST {
    public boolean findTraget(TreeNode root, int k) {
        if (root == null) return false;

        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int i = 0, j = list.size()-1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            }
            if (sum <  k) {
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.data);
        inorder(node.right, list);
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

        int k = 4;

        BTreePrinter.printBinaryTree(root);
        TwoSumInBST sol = new TwoSumInBST();
        System.out.println("Two nodes with sum = " + k + " exists : " + sol.findTraget(root, k));
    }
}
