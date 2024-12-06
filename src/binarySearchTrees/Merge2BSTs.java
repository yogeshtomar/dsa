package binarySearchTrees;

import java.util.ArrayList;
import java.util.List;

public class Merge2BSTs {
    public TreeNode mergeBSTs(TreeNode rootA, TreeNode rootB) {
        List<Integer> listOnr = new ArrayList<>();
        List<Integer> listTwo = new ArrayList<>();

        getSortedListFromInorderTraversal(rootA, listOnr);
        getSortedListFromInorderTraversal(rootB, listTwo);
        List<Integer> mergedList = mergeTwoSortedList(listOnr, listTwo);

        return sortedListToBST(mergedList, 0, mergedList.size()-1);
    }

    private void getSortedListFromInorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        getSortedListFromInorderTraversal(root.left, list);
        list.add(root.data);
        getSortedListFromInorderTraversal(root.right, list);
    }

    private List<Integer> mergeTwoSortedList(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < listOne.size() && j < listTwo.size()) {
            if (listOne.get(i) < listTwo.get(j)) {
                mergedList.add(listOne.get(i++));
            }
            else {
                mergedList.add(listTwo.get(j++));
            }
        }

        while (i < listOne.size()) {
            mergedList.add(listOne.get(i++));
        }
        while (j < listTwo.size()) {
            mergedList.add(listTwo.get(j++));
        }
        return mergedList;
    }

    private TreeNode sortedListToBST(List<Integer> sortedList, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = sortedListToBST(sortedList, start, mid-1);
        node.right = sortedListToBST(sortedList, mid+1, end);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(5);

        // Create second BST
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(6);

        Merge2BSTs sol = new Merge2BSTs();
        System.out.println("Tree 1: ");
        BTreePrinter.printBinaryTree(root1);
        System.out.println("Tree 2");
        BTreePrinter.printBinaryTree(root2);
        TreeNode result = sol.mergeBSTs(root1, root2);
        System.out.println("Merged BST");
        BTreePrinter.printBinaryTree(result);
    }
}
