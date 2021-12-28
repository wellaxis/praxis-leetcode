package com.witalis.praxis.leetcode.task.p108.option;

import com.witalis.praxis.leetcode.task.p108.content.TreeNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 108
 * Name: Convert Sorted Array to Binary Search Tree
 * URL: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public TreeNode process() {
        return sortedArrayToBST(numbers);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        if (nums.length == 1) return new TreeNode(nums[0]);

        return recursiveBST(nums, 0, nums.length - 1);
    }

    private TreeNode recursiveBST(int[] nums, int l, int r) {
        if (l > r) return null;

        int mid = (l + r) / 2;
        return new TreeNode(
            nums[mid],
            recursiveBST(nums, l, mid - 1),
            recursiveBST(nums, mid + 1, r)
        );
    }
}
