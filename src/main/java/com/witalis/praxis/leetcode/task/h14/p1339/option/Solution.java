package com.witalis.praxis.leetcode.task.h14.p1339.option;

import com.witalis.praxis.leetcode.task.h14.p1339.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 1026
 * Name: Maximum Difference Between Node and Ancestor
 * URL: <a href="https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/">Maximum Difference Between Node and Ancestor</a>
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
        return maxProduct(root);
    }

    private List<Integer> allSums = new ArrayList<>();

    public int maxProduct(TreeNode root) {
        final int kMod = 1_000_000_007;

        final long totalSum = treeSum(root);

        long ans = 0;
        for (final long sum : allSums)
            ans = Math.max(ans, sum * (totalSum - sum));

        return (int) (ans % kMod);
    }

    private int treeSum(TreeNode root) {
        if (root == null) return 0;

        final int leftSum = treeSum(root.left);
        final int rightSum = treeSum(root.right);
        final int sum = root.val + leftSum + rightSum;
        allSums.add(sum);

        return sum;
    }
}
