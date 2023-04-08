package com.witalis.praxis.leetcode.task.h10.p905.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 905
 * Name: Sort Array By Parity
 * URL: <a href="https://leetcode.com/problems/sort-array-by-parity/">Sort Array By Parity</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        return sortArrayByParity(numbers);
    }

    public int[] sortArrayByParity(int[] nums) {
        if (nums == null) return new int[0];

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if ((nums[low] & 1) == 0) {
                low++;
            } else if ((nums[high] & 1) != 0) {
                high--;
            } else {
                nums[low] = nums[low] + nums[high] - (nums[high] = nums[low]);
                low++;
                high--;
            }
        }

        return nums;
    }
}
