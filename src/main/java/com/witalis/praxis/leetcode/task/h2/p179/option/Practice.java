package com.witalis.praxis.leetcode.task.h2.p179.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 179
 * Name: Largest Number
 * URL: <a href="https://leetcode.com/problems/largest-number/">Largest Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public String process() {
        return largestNumber(numbers);
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        StringBuilder builder = new StringBuilder();

        Arrays.stream(nums)
            .boxed()
            .sorted((o1, o2) -> ("" + o2 + o1).compareTo("" + o1 + o2))
            .mapToInt(Integer::intValue)
            .forEach(builder::append);

        return (builder.charAt(0) == '0') ? "0" : builder.toString();
    }
}
