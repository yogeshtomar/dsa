package binaryTrees;

import java.util.*;

public class ConstructUniqueBinaryTreeFromPostorderAndInorderTraversals {
    public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if (inorder.size() != postorder.size()) {
            return null;
        }
        Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            inmap.put(inorder.get(i), i);
        }
        TreeNode root = buildTree(inorder, 0, inorder.size()-1, postorder, 0, postorder.size()-1, inmap);
        return root;
    }

    private TreeNode buildTree(List<Integer> inorder, int inStart, int inEnd, List<Integer> postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder.get(postEnd));
        int inRoot = map.get(postorder.get(postEnd));
        int numbsLeft = inRoot - inStart;

        root.left = buildTree(inorder, inStart, inRoot-1, postorder, postStart, postStart + numbsLeft - 1, map);
        root.right = buildTree(inorder, inRoot+1, inEnd, postorder, postStart+numbsLeft, postEnd-1, map);

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
        List<Integer> inorder = new ArrayList<>(Arrays.asList(40, 20, 50, 10, 60, 30));
        List<Integer> postorder = new ArrayList<>(Arrays.asList(40, 50, 20, 60, 30, 10));

        System.out.println("Inorder List: " + inorder.toString());
        System.out.println("Postorder List: " + postorder.toString());

        ConstructUniqueBinaryTreeFromPostorderAndInorderTraversals solution = new ConstructUniqueBinaryTreeFromPostorderAndInorderTraversals();
        TreeNode root = solution.buildTree(inorder, postorder);

        System.out.println("Inorder of Unique Binary Tree Created");
        solution.printInorder(root);
    }
}
