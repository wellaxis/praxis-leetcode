package com.witalis.praxis.leetcode.task.p27.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 27
 * Name: Remove Element
 * URL: https://leetcode.com/problems/remove-element/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;
    private int value;

    public Integer process() {
        return removeElement(numbers, value);
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        var index = Arrays.binarySearch(nums, val);
        if (index < 0) return nums.length;

        int counter = 1, l = index, r = index;
        while (l-1 >= 0 && nums[l-1] == nums[index]) {
            l--;
            counter++;
        }
        while (r+1 <= nums.length - 1 && nums[r+1] == nums[index]) {
            r++;
            counter++;
        }
        int i = 0;
        while (l + i <= r) {
            nums[l + i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = 0;
            i++;
        }
        return nums.length - counter;
    }
}
