package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                sb.append("#,");
            }
            else {
                sb.append(current.data).append(",");
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deSerialize(String input) {
        if (input.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder(input);
        int commaIndex = sb.indexOf(",");
        String str = sb.substring(0, commaIndex);
        sb.delete(0, commaIndex + 1);
        TreeNode root = new TreeNode(Integer.parseInt(str));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            commaIndex = sb.indexOf(",");
            str = sb.substring(0, commaIndex);
            sb.delete(0, commaIndex+1);
            if (!str.equals("#")){
                TreeNode leftNode = new TreeNode(Integer.parseInt(str));
                node.left = leftNode;
                queue.add(leftNode);
            }
            commaIndex = sb.indexOf(",");
            str = sb.substring(0, commaIndex);
            sb.delete(0, commaIndex+1);
            if (!str.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str));
                node.right = rightNode;
                queue.add(rightNode);
            }
        }
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeDeserializeBinaryTree solution = new SerializeDeserializeBinaryTree();
        System.out.println("Original Tree");
        inorder(root);
        String serial = solution.serialize(root);
        System.out.println("Serialized: " + serial);
        TreeNode deserialized = solution.deSerialize(serial);
        System.out.println("Deserialized Tree");
        inorder(deserialized);
    }
}

