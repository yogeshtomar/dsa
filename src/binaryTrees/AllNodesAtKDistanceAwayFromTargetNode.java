package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class AllNodesAtKDistanceAwayFromTargetNode {
    public List<Integer> distanceK(TreeNode root, TreeNode targetNode, int k) {
        List<Integer> result = new ArrayList<>();
        postOrderSearch(root, targetNode, k, result);
        return result;
    }

    private Integer postOrderSearch(TreeNode node, TreeNode target, int k, List<Integer> result) {
        if (node == null) return null;
        Integer leftSubtree = postOrderSearch(node.left, target, k, result);
        Integer rightSubtree = postOrderSearch(node.right, target, k, result);

        if (node.data == target.data) {
            if (k == 0) {
                result.add(node.data);
            }
            findInSubtree(node.left, k-1, result);
            findInSubtree(node.right, k-1, result);
            return 1;
        }

        if (leftSubtree != null) {
            if (k - leftSubtree == 0) {
                result.add(node.data);
            }
            findInSubtree(node.right, k - leftSubtree - 1, result);
            return  leftSubtree + 1;
        }
        if (rightSubtree != null) {
            if (k - rightSubtree == 0) {
                result.add(node.data);
            }
            findInSubtree(node.left, k - rightSubtree - 1, result);
            return rightSubtree + 1;
        }
        return null;
    }

    private void findInSubtree(TreeNode node, int k, List<Integer> result) {
        if ( node == null || k < 0) {
            return;
        }
        if (k == 0) {
            result.add(node.data);
            return;
        }

        findInSubtree(node.left, k - 1, result);
        findInSubtree(node.right, k - 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        AllNodesAtKDistanceAwayFromTargetNode sol = new AllNodesAtKDistanceAwayFromTargetNode();
        TreeNode target = root.left; // target node with value 5
        int k = 2;

        List<Integer> result = sol.distanceK(root, target, k);
        System.out.println("Nodes at distance " + k + " from target node: " + result);
    }
}
