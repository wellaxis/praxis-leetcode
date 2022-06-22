package com.witalis.praxis.leetcode.task.h5.p404.option;

import com.witalis.praxis.leetcode.task.h5.p404.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * ID: 404
 * Name: Sum of Left Leaves
 * URL: <a href="https://leetcode.com/problems/sum-of-left-leaves/">Sum of Left Leaves</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Integer process() {
        return sumOfLeftLeaves(root);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;

        if (root == null) return sum;

        Deque<TreeNode> stack = new ArrayDeque<>(List.of(root));

        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    stack.push(node.left);
                }
            }
        }

        return sum;
    }
}
