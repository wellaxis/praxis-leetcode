package com.witalis.praxis.leetcode.task.h7.p617.option;

import com.witalis.praxis.leetcode.task.h7.p617.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 617
 * Name: Merge Two Binary Trees
 * URL: <a href="https://leetcode.com/problems/merge-two-binary-trees/">Merge Two Binary Trees</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root1;
    private TreeNode root2;

    public TreeNode process() {
        return mergeTrees(root1, root2);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }
}
