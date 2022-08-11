package com.witalis.praxis.leetcode.task.h2.p179.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 179
 * Name: Largest Number
 * URL: <a href="https://leetcode.com/problems/largest-number/">Largest Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public String process() {
        return largestNumber(numbers);
    }

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        StringBuilder builder = new StringBuilder();

        Comparator<Integer> largestNumberSort = (o1, o2) -> {
            if (o2 == null) return 1;
            if (o1.equals(o2)) return 0;

            return ("" + o2 + o1).compareTo("" + o1 + o2);
        };

        Arrays.stream(nums)
            .boxed()
            .sorted(largestNumberSort)
            .mapToInt(Integer::intValue)
            .forEach(builder::append);

        if (builder.charAt(0) == '0') return builder.toString().replaceAll("^0+(?!$)","");

        return builder.toString();
    }
}
