package com.witalis.praxis.leetcode.task.h26.p2553.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 2553
 * Name: Separate the Digits in an Array
 * URL: <a href="https://leetcode.com/problems/separate-the-digits-in-an-array/">Separate the Digits in an Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        return separateDigits(numbers);
    }

    public int[] separateDigits(int[] nums) {
        if (nums == null) return new int[0];

        final List<Integer> answer = new ArrayList<>();

        int[] digits;
        for (int num : nums) {
            int n = (int) Math.log10(num) + 1;
            digits = new int[n--];
            while (num > 0) {
                digits[n--] = num % 10;
                num /= 10;
            }
            for (int digit : digits) answer.add(digit);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
