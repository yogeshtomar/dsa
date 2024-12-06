package binaryTrees;

public class DiameterOfBinaryTree {
    private static int diameter = 0;
    public static Integer diameterOfBinaryTree(TreeNode node, Integer maxDiameter) {
        if (node == null) return 0;


        Integer lh = diameterOfBinaryTree(node.left, maxDiameter);
        Integer rh  = diameterOfBinaryTree(node.right, maxDiameter);

        System.out.println("node data :" + node.data);
        System.out.println("Lh : " + lh + " Rh : " + rh);

        maxDiameter = Math.max(maxDiameter, lh + rh);
        diameter = Math.max(diameter, maxDiameter);
        System.out.println("Maxdiameter : " + maxDiameter);

        return 1 + Math.max(lh, rh);
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
        TreeNode nine = new TreeNode(9);

        root.left = two;
        root.right = three;

        three.left = four;
        four.left = five;
        five.left = nine;

        three.right = six;
        six.right = seven;
        seven.right = eight;
        Integer maxDiameter = 0;
        diameterOfBinaryTree(root, maxDiameter);
        System.out.println("Tree Diameter : " + diameter);
    }
}
