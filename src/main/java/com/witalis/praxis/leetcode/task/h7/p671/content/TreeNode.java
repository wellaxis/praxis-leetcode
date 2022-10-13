package com.witalis.praxis.leetcode.task.h7.p671.content;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

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

    public static TreeNode initTree(int size) {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, size + 1);

        int value = random.nextInt(1, 100);
        TreeNode root = new TreeNode(value);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int counter = 1;
        while (counter <= len && !queue.isEmpty()) {
            TreeNode parent = queue.poll();
            boolean left = counter <= 3 || random.nextBoolean();
            boolean right = counter <= 3 || random.nextBoolean();
            if (left || right) {
                int l = parent.val;
                int r = parent.val;
                if (left && right && random.nextBoolean()) {
                    int addition = random.nextInt(1, 100);
                    if (random.nextBoolean()) {
                        l += addition;
                    } else {
                        r += addition;
                    }
                }
                // left
                if (left) {
                    TreeNode leftChild = new TreeNode(l);
                    parent.left = leftChild;
                    queue.offer(leftChild);
                    counter++;
                }
                // right
                if (right) {
                    TreeNode rightChild = new TreeNode(r);
                    parent.right = rightChild;
                    queue.offer(rightChild);
                    counter++;
                }
            }
        }

        return root;
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
