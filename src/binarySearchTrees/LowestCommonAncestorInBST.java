package binarySearchTrees;

public class LowestCommonAncestorInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.data > p.data && root.data > q.data)
            return lowestCommonAncestor(root.left, p, q);
        if(root.data < p.data && root.data < q.data)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode current = root;
        while (true) {
            while (current.data < p.data && current.data < q.data) {
                current = current.right;
            }
            while (current.data > p.data && current.data > q.data) {
                current = current.left;
            }
            break;
        }
        return current;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        BTreePrinter.printBinaryTree(root);
        TreeNode p = root.left.left;
        TreeNode q = root.right.right;

        System.out.println("LCA of of " + p.data + " and " + q.data + ": ");
        LowestCommonAncestorInBST sol = new LowestCommonAncestorInBST();
        TreeNode lca = sol.lowestCommonAncestor(root, p, q);
        System.out.println(lca.data);
        TreeNode lcaIterative = sol.lowestCommonAncestorIterative(root, p, q);
        System.out.println(lcaIterative.data);
    }
}
