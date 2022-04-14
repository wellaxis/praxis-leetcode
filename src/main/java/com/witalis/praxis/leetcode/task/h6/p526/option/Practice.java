package com.witalis.praxis.leetcode.task.h6.p526.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 526
 * Name: Beautiful Arrangement
 * URL: <a href="https://leetcode.com/problems/beautiful-arrangement/">Beautiful Arrangement</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public Integer process() {
        return countArrangement(number);
    }

    public int countArrangement(int n) {
        int[] array = IntStream.rangeClosed(1, n).toArray();
        return permuting(array, 0, 0);
    }

    public int permuting(int[] array, int element, int counter) {
        if (element == array.length) {
            counter++;
        }
        for (int i = element; i < array.length; i++) {
            swapElements(array, i, element);
            if (array[element] % (element + 1) == 0 || (element + 1) % array[element] == 0) {
                counter = permuting(array, element + 1, counter);
            }
            swapElements(array, i, element);
        }
        return counter;
    }

    public void swapElements(int[] array, int a, int b) {
        var tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
