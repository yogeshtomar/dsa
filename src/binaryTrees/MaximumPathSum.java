package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class MaximumPathSum {
    private static int maxPathSum = Integer.MIN_VALUE;
    public Integer findMaxPathSum(TreeNode node, Integer maxSum) {
        if (node == null) return 0;

       Integer left = Math.max(0, findMaxPathSum(node.left, maxSum));
       Integer right = Math.max(0, findMaxPathSum(node.right, maxSum));

        maxSum = Math.max(maxSum, left + right + node.data);

        if (maxSum > maxPathSum) {
            maxPathSum = maxSum;
        }
//        maxPathSum = Math.max(maxSum, maxPathSum);

        return Math.max(left, right) + node.data;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumPathSum sol = new MaximumPathSum();
        Integer maxSum = Integer.MIN_VALUE;
        sol.findMaxPathSum(root, maxSum);
        System.out.println("Max Path Sum : " + maxPathSum);
    }
}
