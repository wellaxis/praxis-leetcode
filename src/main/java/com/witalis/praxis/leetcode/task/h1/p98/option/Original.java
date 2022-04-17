package com.witalis.praxis.leetcode.task.h1.p98.option;

import com.witalis.praxis.leetcode.task.h1.p98.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 98
 * Name: Validate Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Boolean process() {
        return isValidBST(root);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode previous = null;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (previous != null && previous.val >= current.val) {
                return false;
            }

            previous = current;
            current = current.right;
        }

        return true;
    }
}
