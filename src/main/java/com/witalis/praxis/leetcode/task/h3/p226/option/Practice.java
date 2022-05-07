package com.witalis.praxis.leetcode.task.h3.p226.option;

import com.witalis.praxis.leetcode.task.h3.p226.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 226
 * Name: Invert Binary Tree
 * URL: <a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public TreeNode process() {
        return invertTree(root);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode swap = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = swap;

        return root;
    }
}
