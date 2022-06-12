package com.witalis.praxis.leetcode.task.h2.p129.option;

import com.witalis.praxis.leetcode.task.h2.p129.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 129
 * Name: Sum Root to Leaf Numbers
 * URL: <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">Sum Root to Leaf Numbers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return sumNumbers(root);
    }

    public int sumNumbers(TreeNode root) {
        return treePathsSum(root, 0);
    }

    private int treePathsSum(TreeNode node, int value) {
        if (node == null) return 0;

        value = value * 10 + node.val;
        if (node.left == null && node.right == null) return value;
        return treePathsSum(node.left, value) + treePathsSum(node.right, value);
    }
}
