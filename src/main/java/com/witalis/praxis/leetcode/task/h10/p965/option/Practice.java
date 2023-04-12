package com.witalis.praxis.leetcode.task.h10.p965.option;

import com.witalis.praxis.leetcode.task.h10.p965.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 965
 * Name: Univalued Binary Tree
 * URL: <a href="https://leetcode.com/problems/univalued-binary-tree/">Univalued Binary Tree</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private TreeNode root;

    public Boolean process() {
        return isUnivalTree(root);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
