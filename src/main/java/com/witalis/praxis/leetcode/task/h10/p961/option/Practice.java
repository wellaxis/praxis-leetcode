package com.witalis.praxis.leetcode.task.h10.p961.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 961
 * Name: N-Repeated Element in Size 2N Array
 * URL: <a href="https://leetcode.com/problems/n-repeated-element-in-size-2n-array/">N-Repeated Element in Size 2N Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return repeatedNTimes(numbers);
    }

    public int repeatedNTimes(int[] nums) {
        if (nums == null) return 0;

        final Set<Integer> persistence = new HashSet<>();
        for (int num : nums)
            if (persistence.contains(num)) return num;
            else persistence.add(num);

        return -1;
    }
}
