package com.witalis.praxis.leetcode.task.h11.p1089.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1089
 * Name: Duplicate Zeros
 * URL: <a href="https://leetcode.com/problems/duplicate-zeros/">Duplicate Zeros</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public int[] process() {
        duplicateZeros(numbers);

        return numbers;
    }

    public void duplicateZeros(int[] arr) {
        if (arr == null) return;

        final int n = arr.length;

        int index = 0;
        int shift = 0;

        while (shift + index < n) {
            shift += arr[index] == 0 ? 1 : 0;
            index++;
        }

        while (shift > 0) {
            --index;
            if (index + shift < n) {
                arr[index + shift] = arr[index];
            }
            if (arr[index] == 0) {
                arr[index + --shift] = arr[index];
            }
        }
    }
}
