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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        return sortByBits(numbers);
    }

    public int[] sortByBits(int[] arr) {
        if (arr == null) return new int[0];

        Comparator<Integer> byNumberOfOnes = Original::compareByBits;
        Comparator<Integer> byIntegerValue = Integer::compare;
        return Arrays.stream(arr)
            .boxed()
            .sorted(byNumberOfOnes.thenComparing(byIntegerValue))
            .mapToInt(Integer::intValue)
            .toArray();
    }

    public static int compareByBits(int x, int y) {
        final int xBits = Integer.bitCount(x);
        final int yBits = Integer.bitCount(y);

        return Integer.compare(xBits, yBits);
    }
}
