package com.witalis.praxis.leetcode.task.h3.p222.option;

import com.witalis.praxis.leetcode.task.h3.p222.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 222
 * Name: Count Complete Tree Nodes
 * URL: <a href="https://leetcode.com/problems/count-complete-tree-nodes/">Count Complete Tree Nodes</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Integer process() {
        return countNodes(root);
    }

    public int countNodes(TreeNode root) {
        return solve(root);
    }

    private int solve(TreeNode root) {
        if (root == null) return 0;

        int lh = heightLeft(root);
        int rh = heightRight(root);

        return (lh == rh)
           ? (int) Math.pow(2, lh) - 1
           : 1 + solve(root.left) + solve(root.right);
    }

    private int heightLeft(TreeNode node) {
        int h = 0;
        while (node != null) {
            node = node.left;
            h++;
        }
        return h;
    }

    private int heightRight(TreeNode node) {
        int h = 0;
        while (node != null) {
            node = node.right;
            h++;
        }
        return h;
    }
}
