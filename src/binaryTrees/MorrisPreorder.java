package binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorder {
    public List<Integer> getPreorder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                preorder.add(cur.data);
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;

                    cur = cur.left;
                } else {
                    prev.right = null;
                    preorder.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        MorrisPreorder solution = new MorrisPreorder();
        List<Integer> preorder = solution.getPreorder(root);
        System.out.println("Morris Preorder Traversal");
        System.out.println(preorder.toString());
    }
}
