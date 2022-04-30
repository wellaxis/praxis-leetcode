package com.witalis.praxis.leetcode.task.h2.p114.option;

import com.witalis.praxis.leetcode.task.h2.p114.content.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ID: 114
 * Name: Flatten Binary Tree to Linked List
 * URL: <a href="https://leetcode.com/problems/flatten-binary-tree-to-linked-list/">Flatten Binary Tree to Linked List</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public TreeNode process() {
        flatten(root);
        return root;
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new LinkedList<>();

        TreeNode previous = null;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current == null) {
                current = stack.pop();
                previous.right = current;
            }

            if (current.left != null) {
                if (current.right != null) {
                    stack.push(current.right);
                }
                current.right = current.left;
                current.left = null;
            }

            previous = current;
            current = current.right;
        }
    }
}
