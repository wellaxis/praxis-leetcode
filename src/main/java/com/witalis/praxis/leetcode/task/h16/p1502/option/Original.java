package com.witalis.praxis.leetcode.task.h16.p1502.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 1502
 * Name: Can Make Arithmetic Progression From Sequence
 * URL: <a href="https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/">Can Make Arithmetic Progression From Sequence</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Boolean process() {
        return canMakeArithmeticProgression(numbers);
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr == null || arr.length <= 1) return false;

        Arrays.sort(arr);
        int difference = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != difference) return false;
        }

        return true;
    }
}
