package com.witalis.praxis.leetcode.task.h2.p114.option;

import com.witalis.praxis.leetcode.task.h2.p114.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 114
 * Name: Flatten Binary Tree to Linked List
 * URL: <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public TreeNode process() {
        flatten(root);
        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            if (root.right != null) {
                stack.push(root.right);
            }

            if (root.left != null) {
                root.right = root.left;
                root.left = null;
            } else if (!stack.isEmpty()) {
                root.right = stack.pop();
            }

            root = root.right;
        }
    }
}
