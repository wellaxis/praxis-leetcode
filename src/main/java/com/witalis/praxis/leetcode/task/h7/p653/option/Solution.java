package com.witalis.praxis.leetcode.task.h7.p653.option;

import com.witalis.praxis.leetcode.task.h7.p653.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 653
 * Name: Two Sum IV - Input is a BST
 * URL: <a href="https://leetcode.com/problems/two-sum-iv-input-is-a-bst/">Two Sum IV - Input is a BST</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private TreeNode root;
    private int target;

    public Boolean process() {
        return findTarget(root, target);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);

        for (int i = 0, j = nums.size() - 1; i < j; ) {
            if (nums.get(i) + nums.get(j) == k) return true;
            if (nums.get(i) + nums.get(j) < k) i++;
            else j--;
        }

        return false;
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;

        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }
}
