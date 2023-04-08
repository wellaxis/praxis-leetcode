package com.witalis.praxis.leetcode.task.h10.p905.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 905
 * Name: Sort Array By Parity
 * URL: <a href="https://leetcode.com/problems/sort-array-by-parity/">Sort Array By Parity</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        return sortArrayByParity(numbers);
    }

    public int[] sortArrayByParity(int[] nums) {
        if (nums == null) return new int[0];

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] % 2 == 0) {
                low++;
            } else if (nums[high] % 2 == 1) {
                high--;
            } else {
                int tmp = nums[low];
                nums[low] = nums[high];
                nums[high] = tmp;
                low++;
                high--;
            }
        }

        return nums;
    }
}
