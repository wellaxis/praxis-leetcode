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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Practice(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return diameterOfBinaryTree(root);
    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);
        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}
