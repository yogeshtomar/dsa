package binaryTrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {
    public static List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            }
            else {
                TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    System.out.println(temp.data + " ");
                    result.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.println( temp.data + " ");
                        result.add(temp.data);
                    }
                }
                else {
                    current = temp;
                }
            }
        }
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
        two.left = three;
        three.right = four;
        four.right = five;
        five.right = six;
        root.right = seven;
        seven.left = eight;

        System.out.println("Binary Tree : " );
        root.printTree(root, "", false);

        System.out.println(" Post Order Traversal : " + postOrderIterative(root));


    }
}
