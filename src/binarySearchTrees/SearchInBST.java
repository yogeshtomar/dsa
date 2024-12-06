package binarySearchTrees;



public class SearchInBST {
    public TreeNode search(TreeNode root, int key) {
        while (root != null && root.data != key) {
            root = key < root.data ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        int key = 6;
        SearchInBST sol = new SearchInBST();
        TreeNode target = sol.search(root, key);
        System.out.println(target != null ? "Search successful in BST : " + target.data + " at reference :" + target : "null");
    }
}
