package com.witalis.praxis.leetcode.task.h17.p1640.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1640
 * Name: Check Array Formation Through Concatenation
 * URL: <a href="https://leetcode.com/problems/check-array-formation-through-concatenation/">Check Array Formation Through Concatenation</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] array;
    private int[][] pieces;

    public Boolean process() {
        return canFormArray(array, pieces);
    }

    public boolean canFormArray(int[] array, int[][] pieces) {
        int index = 0;
        var previous = pieces;
        var current = pieces;
        int unnecessary = -1;
        while (index < array.length) {
            int a = array[index];
            boolean check = false;
            if (unnecessary >= 0) {
                current = new int[previous.length - 1][];
                System.arraycopy(previous, 0, current, 0, unnecessary);
                System.arraycopy(previous, unnecessary + 1, current, unnecessary, previous.length - (unnecessary + 1));
                unnecessary = -1;
            }
            for (int i = 0; i < current.length; i++) {
                int[] sub = current[i];
                if (sub[0] == a) {
                    for (int j = 1; j < sub.length; j++) {
                        if (sub[j] != array[index + j]) return false;
                    }
                    index += sub.length;
                    check = true;
                    unnecessary = i;
                    previous = current;
                    break;
                }
            }
            if (!check) return false;
        }
        return true;
    }
}
