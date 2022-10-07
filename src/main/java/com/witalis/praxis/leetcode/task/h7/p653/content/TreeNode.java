package com.witalis.praxis.leetcode.task.h7.p653.content;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode initTree(int[] array) {
        if (array.length == 0) return new TreeNode();

        return initBSTTree(array, 0, array.length - 1);
    }

    public static TreeNode initBSTTree(int[] array, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = initBSTTree(array, start, mid - 1);
        root.right = initBSTTree(array, mid + 1, end);

        return root;
    }

    public static TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;

        TreeNode node = new TreeNode(root.val);

        node.left = cloneTree(root.left);
        node.right = cloneTree(root.right);

        return node;
    }

    public static TreeNode findNode(TreeNode node, int value) {
        if (node == null) return null;
        if (node.val == value) return node;

        var result = findNode(node.left, value);
        if (result != null) return result;
        return findNode(node.right, value);
    }

    @Override
    public String toString() {
        return showNode(this);
    }

    public String showNode(TreeNode node) {
        return (node == null) ? "" : node.val + " -> " + showNode(node.left) + showNode(node.right);
    }
}
