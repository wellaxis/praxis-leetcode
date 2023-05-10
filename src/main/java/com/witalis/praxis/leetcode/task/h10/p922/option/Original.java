package com.witalis.praxis.leetcode.task.h10.p922.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 922
 * Name: Sort Array By Parity II
 * URL: <a href="https://leetcode.com/problems/sort-array-by-parity-ii/">Sort Array By Parity II</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        return sortArrayByParityII(numbers);
    }

    public int[] sortArrayByParityII(int[] nums) {
        if (nums == null) return new int[0];

        final int n = nums.length;
        final int[] ans = new int[n];

        int even = 0;
        int odd = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[even] = num;
                even += 2;
            } else {
                ans[odd] = num;
                odd += 2;
            }
        }

        return ans;
    }
}
