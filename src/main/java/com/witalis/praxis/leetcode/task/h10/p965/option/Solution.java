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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Boolean process() {
        return isUnivalTree(root);
    }

    public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));

        return left_correct && right_correct;
    }
}
