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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private TreeNode root;

    public TreeNode process() {
        return invertTree(root);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
