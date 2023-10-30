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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public int[] process() {
        return sortByBits(numbers);
    }

    static class CustomComparator implements Comparator<Integer> {
        private int findWeight(int num) {
            int weight = 0;

            while (num > 0) {
                weight++;
                num &= (num - 1);
            }

            return weight;
        }

        @Override
        public int compare(Integer a, Integer b) {
            if (findWeight(a) == findWeight(b)) {
                return a - b;
            }

            return findWeight(a) - findWeight(b);
        }
    }

    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);

        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}
