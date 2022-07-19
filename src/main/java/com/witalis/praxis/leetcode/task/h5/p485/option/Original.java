package com.witalis.praxis.leetcode.task.h5.p485.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 485
 * Name: Max Consecutive Ones
 * URL: <a href="https://leetcode.com/problems/max-consecutive-ones/">Max Consecutive Ones</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return findMaxConsecutiveOnes(numbers);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        return IntStream.range(0, nums.length - 1)
            .map(i -> (nums[i + 1] == 1) ? nums[i + 1] += nums[i] : nums[i])
            .max().orElse(nums[0]);
    }
}
