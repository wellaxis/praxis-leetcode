package com.witalis.praxis.leetcode.task.h13.p1287.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1287
 * Name: Element Appearing More Than 25% In Sorted Array
 * URL: <a href="https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/">Element Appearing More Than 25% In Sorted Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] array;

    public Integer process() {
        return findSpecialInteger(array);
    }

    public int findSpecialInteger(int[] arr) {
        int size = arr.length / 4;
        for (int i = 0; i < arr.length - size; i++) {
            if (arr[i] == arr[i + size]) {
                return arr[i];
            }
        }

        return -1;
    }
}
