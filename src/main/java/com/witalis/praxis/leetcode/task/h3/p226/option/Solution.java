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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public TreeNode process() {
        return invertTree(root);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;

        return root;
    }
}
