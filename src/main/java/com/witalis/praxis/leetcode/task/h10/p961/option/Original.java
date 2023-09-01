package com.witalis.praxis.leetcode.task.h10.p961.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 961
 * Name: N-Repeated Element in Size 2N Array
 * URL: <a href="https://leetcode.com/problems/n-repeated-element-in-size-2n-array/">N-Repeated Element in Size 2N Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return repeatedNTimes(numbers);
    }

    public static final int VALUE = 10_000;

    public int repeatedNTimes(int[] nums) {
        if (nums == null) return 0;

        final boolean[] persistence = new boolean[VALUE];
        for (int num : nums)
            if (persistence[num]) return num;
            else persistence[num] = true;

        return -1;
    }
}
