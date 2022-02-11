package com.witalis.praxis.leetcode.task.h1.p80.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 80
 * Name: Remove Duplicates from Sorted Array II
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return removeDuplicates(numbers);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length < 3) return nums.length;

        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 2]) {
                nums[slow++] = nums[fast];
            } else if (nums[slow] != nums[slow - 2] && nums[slow] == nums[slow - 1]) {
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
