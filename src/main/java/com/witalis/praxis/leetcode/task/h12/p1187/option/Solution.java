package com.witalis.praxis.leetcode.task.h12.p1187.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1187
 * Name: Make Array Strictly Increasing
 * URL: <a href="https://leetcode.com/problems/make-array-strictly-increasing/">Make Array Strictly Increasing</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] array1;
    private int[] array2;

    public Integer process() {
        return makeArrayIncreasing(array1, array2);
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        final int n = arr2.length;

        Arrays.sort(arr2);

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(-1, 0);

        for (int i = 0; i < arr1.length; i++) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (int prev : dp.keySet()) {
                if (arr1[i] > prev) {
                    newDp.put(arr1[i], Math.min(newDp.getOrDefault(arr1[i], Integer.MAX_VALUE), dp.get(prev)));
                }
                int idx = bisectRight(arr2, prev);
                if (idx < n) {
                    newDp.put(arr2[idx], Math.min(newDp.getOrDefault(arr2[idx], Integer.MAX_VALUE), 1 + dp.get(prev)));
                }
            }
            dp = newDp;
        }

        int answer = Integer.MAX_VALUE;
        for (int value : dp.values()) {
            answer = Math.min(answer, value);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static int bisectRight(int[] arr, int value) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
