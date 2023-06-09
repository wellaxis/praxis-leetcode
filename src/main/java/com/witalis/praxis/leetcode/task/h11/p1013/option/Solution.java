package com.witalis.praxis.leetcode.task.h11.p1013.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1013
 * Name: Partition Array Into Three Parts With Equal Sum
 * URL: <a href="https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/">Partition Array Into Three Parts With Equal Sum</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return canThreePartsEqualSum(numbers);
    }

    public boolean canThreePartsEqualSum(int[] arr) {
        final int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0)
            return false;

        final int average = sum / 3;
        int partCount = 0;
        int partSum = 0;

        for (final int a : arr) {
            partSum += a;
            if (partSum == average) {
                ++partCount;
                partSum = 0;
            }
        }

        return partCount >= 3;
    }
}
