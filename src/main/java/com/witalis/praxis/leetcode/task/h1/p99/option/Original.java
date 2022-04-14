package com.witalis.praxis.leetcode.task.h1.p99.option;

import com.witalis.praxis.leetcode.task.h1.p99.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 99
 * Name: Recover Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/recover-binary-search-tree/">Recover Binary Search Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public TreeNode process() {
        recoverTree(root);
        return root;
    }

    public void recoverTree(TreeNode root) {
        if (root == null) return;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode wrong1 = null;
        TreeNode wrong2 = null;

        TreeNode previous = null;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            if (previous != null && current.val < previous.val) {
                if (wrong1 == null) {
                    wrong1 = previous;
                }
                wrong2 = current;
            }
            previous = current;
            current = current.right;
        }

        // swap
        int value = wrong1.val;
        wrong1.val = wrong2.val;
        wrong2.val = value;
    }
}
