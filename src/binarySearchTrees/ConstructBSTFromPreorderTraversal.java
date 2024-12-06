package binarySearchTrees;

import java.util.Arrays;
import java.util.List;

public class ConstructBSTFromPreorderTraversal {
    int index = 0;
    public TreeNode constructBST(int[] preorder) {
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode constructBST(int[] preorder, int low, int high) {
        if (index >= preorder.length || preorder[index] < low || preorder[index] > high) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index++]);
        node.left = constructBST(preorder, low, node.data);
        node.right = constructBST(preorder, node.data, high);

        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        System.out.println("Preorder: " + Arrays.toString(preorder));

        ConstructBSTFromPreorderTraversal sol = new ConstructBSTFromPreorderTraversal();
        TreeNode root = sol.constructBST(preorder);

        System.out.println("BST from preorder: ");
        BTreePrinter.printBinaryTree(root);
    }
}
