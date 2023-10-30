package com.witalis.praxis.leetcode.task.h14.p1356.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ID: 1356
 * Name: Sort Integers by The Number of 1 Bits
 * URL: <a href="https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/">Sort Integers by The Number of 1 Bits</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        return sortByBits(numbers);
    }

    public int[] sortByBits(int[] arr) {
        if (arr == null) return new int[0];

        return Arrays.stream(arr)
            .boxed()
            .sorted(Comparator.comparingInt(Integer::bitCount).thenComparing(Integer::compare))
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
