package com.witalis.praxis.leetcode.task.h5.p414.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;

/**
 * ID: 414
 * Name: Third Maximum Number
 * URL: <a href="https://leetcode.com/problems/third-maximum-number/">Third Maximum Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return thirdMax(numbers);
    }

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("array should be specified");

        return Arrays.stream(nums)
            .distinct()
            .boxed()
            .sorted(Collections.reverseOrder())
            .skip(2)
            .findFirst()
            .orElse(
                Arrays.stream(nums)
                    .max()
                    .orElse(0)
            );
    }
}
