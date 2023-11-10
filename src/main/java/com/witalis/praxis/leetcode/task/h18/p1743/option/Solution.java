package com.witalis.praxis.leetcode.task.h18.p1743.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1743
 * Name: Restore the Array From Adjacent Pairs
 * URL: <a href="https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/">Restore the Array From Adjacent Pairs</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[][] pairs;

    public int[] process() {
        return restoreArray(pairs);
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int[] out : adjacentPairs) {
            if (map.containsKey(out[0])) {
                map.get(out[0])[1] = out[1];
            } else {
                map.put(out[0], new int[]{out[1], Integer.MIN_VALUE});
            }

            if (map.containsKey(out[1])) {
                map.get(out[1])[1] = out[0];
            } else {
                map.put(out[1], new int[]{out[0], Integer.MIN_VALUE});
            }
        }

        int[] output = new int[adjacentPairs.length + 1];

        int start = Integer.MIN_VALUE;
        for (Map.Entry<Integer, int[]> entr : map.entrySet()) {
            if (entr.getValue()[1] == Integer.MIN_VALUE) {
                start = entr.getKey();
                break;
            }
        }

        output[0] = start;

        int prev = Integer.MIN_VALUE;
        for (int i = 1; i < output.length; i++) {
            int[] out = map.get(start);

            if (prev == out[0]) {
                start = out[1];
            } else {
                start = out[0];
            }
            prev = output[i - 1];
            output[i] = start;
        }

        return output;
    }
}
