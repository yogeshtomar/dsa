package binaryTrees;

import java.util.*;

public class ConstructUniqueBinaryTreeFromInorderAndPreorderTraversals {
    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            inMap.put(inorder.get(i), i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.size()-1, inorder, 0, inorder.size()-1, inMap);
        return root;
    }
    private TreeNode buildTree(List<Integer> preorder, int preStart, int preEnd, List<Integer> inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder.get(preStart));
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot-1, inMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap);
        return root;
    }

    private void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {
        List<Integer> inorder = new ArrayList<>(Arrays.asList(9, 3, 15, 20, 7));
        List<Integer> preorder = new ArrayList<>(Arrays.asList(3, 9, 20, 15, 7));

        System.out.println("Inorder : " + inorder.toString());
        System.out.println("Preorder : " + preorder.toString());
        ConstructUniqueBinaryTreeFromInorderAndPreorderTraversals solution = new ConstructUniqueBinaryTreeFromInorderAndPreorderTraversals();
        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.println("Unique Binary Tree: ");
        solution.printInorder(root);
    }
}
