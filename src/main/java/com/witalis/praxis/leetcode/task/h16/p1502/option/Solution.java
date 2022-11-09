package com.witalis.praxis.leetcode.task.h16.p1502.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1502
 * Name: Can Make Arithmetic Progression From Sequence
 * URL: <a href="https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/">Can Make Arithmetic Progression From Sequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Boolean process() {
        return canMakeArithmeticProgression(numbers);
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        int minValue = Math.min(arr[0], arr[1]);
        int secondMinValue = Math.max(arr[0], arr[1]);

        boolean areAllElementsEqual = (arr[0] == arr[1]);
        for (int i = 2; i < arr.length; i++) {
            if (areAllElementsEqual) {
                areAllElementsEqual = arr[i] == minValue;
            }
            if (arr[i] < minValue) {
                secondMinValue = minValue;
                minValue = arr[i];
            } else if (arr[i] < secondMinValue) {
                secondMinValue = arr[i];
            }
        }

        if (areAllElementsEqual) {
            return true;
        }

        int distance = secondMinValue - minValue;
        if (distance == 0) return false;

        boolean[] encounteredValues = new boolean[arr.length];

        int index;
        for (int j : arr) {
            if ((j - minValue) % distance > 0) return false;

            index = (j - minValue) / distance;
            if ((index > encounteredValues.length - 1) || encounteredValues[index]) return false;

            encounteredValues[index] = true;
        }

        for (boolean encounteredValue : encounteredValues) {
            if (!encounteredValue) return false;
        }

        return true;
    }
}
