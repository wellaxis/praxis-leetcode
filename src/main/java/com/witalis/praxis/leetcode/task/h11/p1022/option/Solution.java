package com.witalis.praxis.leetcode.task.h11.p1022.option;

import com.witalis.praxis.leetcode.task.h11.p1022.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1022
 * Name: Sum of Root To Leaf Binary Numbers
 * URL: <a href="https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/">Sum of Root To Leaf Binary Numbers</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;

    public Solution(TreeNode root) {
        this.root = root;
    }

    public Integer process() {
        return sumRootToLeaf(root);
    }

    private int rootToLeaf = 0;

    public void preorder(TreeNode r, int currNumber) {
        if (r != null) {
            currNumber = (currNumber << 1) | r.val;

            if (r.left == null && r.right == null) {
                rootToLeaf += currNumber;
            }
            preorder(r.left, currNumber);
            preorder(r.right, currNumber);
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        preorder(root, 0);

        return rootToLeaf;
    }
}
