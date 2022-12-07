package com.witalis.praxis.leetcode.task.h10.p938.option;

import com.witalis.praxis.leetcode.task.h10.p938.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 938
 * Name: Range Sum of BST
 * URL: <a href="https://leetcode.com/problems/range-sum-of-bst/">Range Sum of BST</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;
    private int low;
    private int high;

    public Solution(TreeNode root, int low, int high) {
        this.root = root;
        this.low = low;
        this.high = high;
    }

    public Integer process() {
        return rangeSumBST(root, low, high);
    }

    private int ans;

    public int rangeSumBST(TreeNode root, int low, int high) {
        ans = 0;
        dfs(root, low, high);
        return ans;
    }

    public void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            if (low <= node.val && node.val <= high)
                ans += node.val;
            if (low < node.val)
                dfs(node.left, low, high);
            if (node.val < high)
                dfs(node.right, low, high);
        }
    }
}
