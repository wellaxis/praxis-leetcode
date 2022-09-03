package com.witalis.praxis.leetcode.task.h6.p572.option;

import com.witalis.praxis.leetcode.task.h6.p572.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 572
 * Name: Subtree of Another Tree
 * URL: <a href="https://leetcode.com/problems/subtree-of-another-tree/">Subtree of Another Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;
    private TreeNode subRoot;

    public Boolean process() {
        return isSubtree(root, subRoot);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSame(root, subRoot);
    }

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null || root1.val != root2.val) return false;

        return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}
