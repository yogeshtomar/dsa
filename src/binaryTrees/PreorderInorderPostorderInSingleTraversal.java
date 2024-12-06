package binaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderInorderPostorderInSingleTraversal {
    public static List<List<Integer>> preInPostTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return new ArrayList<>();
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        stack.push(new Pair<>(root, 1));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            if (current.getValue() == 1) {
                preorder.add(current.getNode().data);
                current.setValue(2);
                stack.push(current);
                if (current.getNode().left != null) {
                    stack.push(new Pair<>(current.getNode().left, 1));
                }
            }

            else if (current.getValue() == 2) {
                inorder.add(current.getNode().data);
                current.setValue(3);
                stack.push(current);
                if (current.getNode().right != null) {
                    stack.push(new Pair<>(current.getNode().right, 1));
                }
            }

            else {
                postorder.add(current.getNode().data);
            }
        }

        result.add(preorder);
        result.add(inorder);
        result.add(postorder);

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        root.left = two;
        root.right = five;
        root.left.left = three;
        root.left.right = four;
        root.right.left = six;
        root.right.right = seven;
        root.right.right.left = eight;

        List<List<Integer>> ans = preInPostTraversal(root);
        List<Integer> preorder = ans.get(0);
        List<Integer> inorder = ans.get(1);
        List<Integer> postorder = ans.get(2);

        System.out.println("PreOrder : " + preorder.toString());
        System.out.println("InOrder : " + inorder.toString());
        System.out.println("PostOrder : " + postorder.toString());
    }
}
