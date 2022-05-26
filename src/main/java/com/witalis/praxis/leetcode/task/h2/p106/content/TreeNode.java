package com.witalis.praxis.leetcode.task.h2.p106.content;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Traversal: DFS, depth-first preorder
     */
    public static int[] preorder(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        if (root == null) return new int[] {};

        TreeNode current = root;
        TreeNode predecessor;

        while (current != null) {
            if (current.left == null) {
                // step 1
                traversal.add(current.val);
                current = current.right;
            } else {
                // step 2 - find the preorder predecessor of current node
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // make current as right child of its preorder predecessor
                if (predecessor.right == null) {
                    // the only difference from inorder traversal
                    traversal.add(current.val);
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // revert the changes & restore the original tree
                    // i.e., fix the right child of predecessor
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }

        return traversal.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Traversal: DFS, depth-first inorder
     */
    public static int[] inorder(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        if (root == null) return new int[] {};

        TreeNode current = root;
        TreeNode predecessor;

        while (current != null) {
            if (current.left == null) {
                // step 1
                traversal.add(current.val);
                current = current.right;
            } else {
                // step 2 - find the inorder predecessor of current node
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // make current as right child of its inorder predecessor
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // the only difference from preorder traversal
                    traversal.add(current.val);
                    // revert the changes & restore the original tree
                    // i.e., fix the right child of predecessor
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }

        return traversal.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Traversal: DFS, depth-first postorder
     */
    public static int[] postorder(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();

        if (root == null) return new int[] {};

        // create a dummy node
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode current = dummy;

        // define some useful variables
        TreeNode parent;
        TreeNode middle;
        TreeNode predecessor;
        TreeNode back;

        // iterating tree nodes
        while (current != null) {
            if (current.left == null) {
                // step 1
                current = current.right;
            } else {
                // step 2 - find the postorder predecessor of current node
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // make current as left child of its postorder predecessor
                if (predecessor.right != current) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    parent = current;
                    middle = current.left;
                    // update new path
                    while (middle != current) {
                        back = middle.right;
                        middle.right = parent;
                        parent = middle;
                        middle = back;
                    }
                    parent = current;
                    middle = predecessor;
                    // correct node link in current path
                    while (middle != current) {
                        traversal.add(middle.val);
                        back = middle.right;
                        middle.right = parent;
                        parent = middle;
                        middle = back;
                    }
                    // unlink previous bind element
                    predecessor.right = null;
                    // visit to right child
                    current = current.right;
                }
            }
        }

        return traversal.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public String toString() {
        return showNode(this);
    }

    public String showNode(TreeNode node) {
        return (node == null) ? "" : node.val + " -> " + showNode(node.left) + showNode(node.right);
    }
}
