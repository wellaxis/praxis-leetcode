package com.witalis.praxis.leetcode.task.h2.p189.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 189
 * Name: Rotate Array
 * URL: <a href="https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;
    private int steps;

    public int[] process() {
        rotate(numbers, steps);
        return numbers;
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0 || k == nums.length) return;

        int len = nums.length;
        k %= len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    /**
     * It rotates an array via system arraycopy functionality.
     */
    public int[] rotateCopy(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0 || k == nums.length) return nums;

        int[] ans = new int[nums.length];
        System.arraycopy(nums, nums.length - k, ans, 0, k);
        System.arraycopy(nums, 0, ans, k, nums.length - k);
        return ans;
    }

    /**
     * It rotates an array via collections rotate functionality.
     */
    public int[] rotateList(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0 || k == nums.length) return nums;

        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        Collections.rotate(list, k);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
