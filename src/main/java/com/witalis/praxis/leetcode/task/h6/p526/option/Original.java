package com.witalis.praxis.leetcode.task.h6.p526.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 526
 * Name: Beautiful Arrangement
 * URL: https://leetcode.com/problems/beautiful-arrangement/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return countArrangement(number);
    }

    public int countArrangement(int n) {
        int[] array = IntStream.rangeClosed(1, n).toArray();
        return permuting(array, 0, 0);
    }

    public int permuting(int[] array, int element, int counter) {
        for (int i = element; i < array.length; i++) {
            swapElements(array, i, element);
            counter = permuting(array, element + 1, counter);
            swapElements(array, element, i);
        }
        if (element == array.length - 1) {
            if (beautifulCheck(array)) {
                counter++;
            }
        }
        return counter;
    }

    public void swapElements(int[] array, int a, int b) {
        var tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public boolean beautifulCheck(int[] array) {
        for (int i = 0; i < array.length; i++) {
            var check = array[i] % (i + 1) == 0 || (i + 1) % array[i] == 0;
            if (!check) return false;
        }
        return true;
    }
}
