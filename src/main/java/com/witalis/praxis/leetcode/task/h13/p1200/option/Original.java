package com.witalis.praxis.leetcode.task.h13.p1200.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ID: 1200
 * Name: Minimum Absolute Difference
 * URL: <a href="https://leetcode.com/problems/minimum-absolute-difference/">Minimum Absolute Difference</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public List<List<Integer>> process() {
        return minimumAbsDifference(numbers);
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length == 0) return Collections.emptyList();

        List<List<Integer>> pairs = new ArrayList<>();

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if (diff <= minDiff) {
                if (diff < minDiff) {
                    pairs.clear();
                    minDiff = diff;
                }
                pairs.add(List.of(arr[i - 1], arr[i]));
            }
        }

        return pairs;
    }
}
