package com.witalis.praxis.leetcode.task.h26.p2553.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * ID: 2553
 * Name: Separate the Digits in an Array
 * URL: <a href="https://leetcode.com/problems/separate-the-digits-in-an-array/">Separate the Digits in an Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        return separateDigits(numbers);
    }

    public int[] separateDigits(int[] nums) {
        if (nums == null) return new int[0];

        return Arrays.stream(nums).sequential().flatMap(Original::separate).toArray();
    }

    public static IntStream separate(int num) {
        final List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        Collections.reverse(digits);
        return digits.stream().mapToInt(Integer::intValue);
    }
}
