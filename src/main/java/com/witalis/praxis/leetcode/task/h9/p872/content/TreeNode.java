package com.witalis.praxis.leetcode.task.h9.p872.content;

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

    public static TreeNode initTree(Integer[] arr, TreeNode root, int i) {
        if (i < arr.length && arr[i] != null) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left = initTree(arr, root.left, 2 * i + 1);
            // insert right child
            root.right = initTree(arr, root.right, 2 * i + 2);
        }
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
