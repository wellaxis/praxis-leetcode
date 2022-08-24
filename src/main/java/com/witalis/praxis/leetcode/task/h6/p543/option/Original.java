package com.witalis.praxis.leetcode.task.h6.p543.option;

import com.witalis.praxis.leetcode.task.h6.p543.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 543
 * Name: Diameter of Binary Tree
 * URL: <a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public Integer process() {
        return diameterOfBinaryTree(root);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int[] diameter = new int[] {0};
        dfs(root, diameter);
        return diameter[0];
    }

    private int dfs(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        int left = dfs(node.left, diameter);
        int right = dfs(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);

        return Math.max(left, right) + 1;
    }
}
