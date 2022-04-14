package com.witalis.praxis.leetcode.task.h17.p1640.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * ID: 1640
 * Name: Check Array Formation Through Concatenation
 * URL: <a href="https://leetcode.com/problems/check-array-formation-through-concatenation/">Check Array Formation Through Concatenation</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] array;
    private int[][] pieces;

    public Boolean process() {
        return canFormArray(array, pieces);
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int[] piece : pieces) {
            if (!map.containsKey(piece[0])) return false;
            int index = map.get(piece[0]);

            for (int j = 1; j < piece.length; j++) {
                if (!map.containsKey(piece[j])) return false;
                if (map.get(piece[j]) != index + 1) return false;
                index++;
            }
        }
        return true;
    }
}
