package com.witalis.praxis.leetcode.task.h2.p124.option;

import com.witalis.praxis.leetcode.task.h2.p124.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 124
 * Name: Binary Tree Maximum Path Sum
 * URL: <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">Binary Tree Maximum Path Sum</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return maxPathSum(root);
    }

    public int maxPathSum(TreeNode root) {
        ThreadLocal<Integer> maxSum = ThreadLocal.withInitial(() -> Integer.MIN_VALUE);
        recursiveMaxPathSum(root, maxSum);
        return maxSum.get();
    }

    private int recursiveMaxPathSum(TreeNode node, ThreadLocal<Integer> maxSum) {
        if (node == null) return 0;

        int leftSum = Math.max(0, recursiveMaxPathSum(node.left, maxSum));
        int rightSum = Math.max(0, recursiveMaxPathSum(node.right, maxSum));

        maxSum.set(Math.max(maxSum.get(), node.val + leftSum + rightSum));

        return node.val + Math.max(leftSum, rightSum);
    }
}
