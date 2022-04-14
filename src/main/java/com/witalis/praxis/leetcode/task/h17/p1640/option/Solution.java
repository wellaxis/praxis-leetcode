package com.witalis.praxis.leetcode.task.h17.p1640.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 1640
 * Name: Check Array Formation Through Concatenation
 * URL: <a href="https://leetcode.com/problems/check-array-formation-through-concatenation/">Check Array Formation Through Concatenation</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] array;
    private int[][] pieces;

    public Boolean process() {
        return canFormArray(array, pieces);
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] ints : pieces) {
            map.put(ints[0], ints);
        }
        int i = 0;
        while (i < arr.length) {
            int num = arr[i];
            if (!map.containsKey(num)) {
                return false;
            }
            int[] piece = map.get(num);
            int j = 0;
            while (j < piece.length) {
                if (piece[j] != arr[i]) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return true;
    }
}
