package binaryTrees;

public class LowestCommonAncestor {
    public TreeNode findLowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root ==  b) {
            return root;
        }

        TreeNode leftSubTree = findLowestCommonAncestor(root.left, a, b);
        TreeNode rightSubTree = findLowestCommonAncestor(root.right, a, b);

        if (leftSubTree == null) {
            return rightSubTree;
        }

        if (rightSubTree == null) {
            return leftSubTree;
        }

        else {
            return root;
        }
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

        TreeNode a = root.left.right.left;
        TreeNode b = root.left.left;

        LowestCommonAncestor lca = new LowestCommonAncestor();
        System.out.println("Lowest Common Ancestor : " + lca.findLowestCommonAncestor(root, a, b).data);
    }
}
