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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Integer process() {
        return sumNumbers(root);
    }

    public int sumNumbers(TreeNode root) {
        return recursiveSum(root, 0);
    }

    private int recursiveSum(TreeNode node, int sum) {
        if (node == null) return 0;

        sum += node.val;
        if (node.left == null && node.right == null) return sum;
        return recursiveSum(node.left, sum * 10) + recursiveSum(node.right, sum * 10);
    }
}
