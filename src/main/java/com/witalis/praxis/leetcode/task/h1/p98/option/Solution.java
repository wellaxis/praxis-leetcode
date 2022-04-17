package com.witalis.praxis.leetcode.task.h1.p98.option;

import com.witalis.praxis.leetcode.task.h1.p98.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 98
 * Name: Validate Binary Search Tree
 * URL: <a href="https://leetcode.com/problems/validate-binary-search-tree/">Validate Binary Search Tree</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Boolean process() {
        return isValidBST(root);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;

        if(root.val >= max || root.val <= min) return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
