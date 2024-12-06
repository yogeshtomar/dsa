package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    private boolean getPath(TreeNode root, List<Integer> path, int key) {
        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == key) {
            return true;
        }

        if (getPath(root.left, path, key) || getPath(root.right, path, key)) {
            return true;
        }

        path.removeLast();
        return false;
    }

    public List<Integer> getRootToNodePath(TreeNode root, int key) {
        List<Integer> path = new ArrayList<>();

        if (root == null) {
            return path;
        }

        getPath(root, path, key);

        return path;
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

        RootToNodePath obj = new RootToNodePath();
        int targetLeft = 7;
        System.out.println("Root To Node Path : " + obj.getRootToNodePath(root, targetLeft));
    }
}
