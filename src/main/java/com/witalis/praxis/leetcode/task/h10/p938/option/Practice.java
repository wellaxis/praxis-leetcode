package com.witalis.praxis.leetcode.task.h10.p938.option;

import com.witalis.praxis.leetcode.task.h10.p938.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * ID: 938
 * Name: Range Sum of BST
 * URL: <a href="https://leetcode.com/problems/range-sum-of-bst/">Range Sum of BST</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;
    private int low;
    private int high;

    public Integer process() {
        return rangeSumBST(root, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<>(Set.of(root));
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();

            if (low <= node.val && node.val <= high) sum += node.val;

            if (node.val <= high && node.right != null) stack.push(node.right);
            if (node.val >= low && node.left != null) stack.push(node.left);
        }

        return sum;
    }
}
