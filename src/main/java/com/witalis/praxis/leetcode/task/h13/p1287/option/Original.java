package com.witalis.praxis.leetcode.task.h13.p1287.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1287
 * Name: Element Appearing More Than 25% In Sorted Array
 * URL: <a href="https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/">Element Appearing More Than 25% In Sorted Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] array;

    public Integer process() {
        return findSpecialInteger(array);
    }

    public int findSpecialInteger(int[] arr) {
        if (arr == null) return 0;

        final int n = arr.length;
        final int threshold = n / 4;
        final int[] frequencies = new int[100_001];

        for (int num : arr) {
            if (++frequencies[num] > threshold) {
                return num;
            }
        }

        return -1;
    }
}
