package com.witalis.praxis.leetcode.task.h2.p116.content;

/**
 * Definition for a node.
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public static Node initTree(int height) {
        if (height <= 0) return new Node();
        return initTree(new Node(), height, 0, 1);
    }

    private static Node initTree(Node root, int height, int currentLevel, int value) {
        if (currentLevel >= height) return root;

        root = new Node(value);

        // insert left child
        root.left = initTree(root.left, height, currentLevel + 1, 2 * value);
        // insert right child
        root.right = initTree(root.right, height, currentLevel + 1, 2 * value + 1);

        return root;
    }

    public static Node cloneTree(Node root) {
        if (root == null) return null;

        Node node = new Node(root.val);

        node.left = cloneTree(root.left);
        node.right = cloneTree(root.right);

        return node;
    }

    public static Node findNode(Node node, int value) {
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

    public String showNode(Node node) {
        if (node == null) return "";
        String nextValue = " [" + ((node.next == null) ? "#" : node.next.val) + "]";
        return node.val + nextValue + " -> " + showNode(node.left) + showNode(node.right);
    }
}
