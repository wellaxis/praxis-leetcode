package com.witalis.praxis.leetcode.task.h6.p530.option;

import com.witalis.praxis.leetcode.task.h6.p530.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 530
 * Name: Minimum Absolute Difference in BST
 * URL: <a href="https://leetcode.com/problems/minimum-absolute-difference-in-bst/">Minimum Absolute Difference in BST</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return getMinimumDifference(root);
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return -1;

        int min = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode previous = null;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode node = stack.pop();
                if (previous != null) min = Math.min(min, node.val - previous.val);
                previous = node;
                current = node.right;
            }
        }

        return min;
    }
}
