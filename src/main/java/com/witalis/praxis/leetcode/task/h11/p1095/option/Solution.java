package com.witalis.praxis.leetcode.task.h11.p1095.option;

import com.witalis.praxis.leetcode.task.h11.p1095.content.MountainArray;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1095
 * Name: Find in Mountain Array
 * URL: <a href="https://leetcode.com/problems/find-in-mountain-array/">Find in Mountain Array</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int target;
    private MountainArray mountainArray;

    public Integer process() {
        return findInMountainArray(target, mountainArray);
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        // save the length of the mountain array
        int length = mountainArr.length();

        // 1. find the index of the peak element
        int low = 1;
        int high = length - 2;
        while (low != high) {
            int testIndex = (low + high) >> 1;
            int curr = mountainArr.get(testIndex);
            int next = mountainArr.get(testIndex + 1);

            if (curr < next) {
                if (curr == target) {
                    return testIndex;
                }
                if (next == target) {
                    return testIndex + 1;
                }
                low = testIndex + 1;
            } else {
                high = testIndex;
            }
        }
        int peakIndex = low;

        // 2. search in the strictly increasing part of the array
        // if found, will be returned in the loop itself
        low = 0;
        high = peakIndex;
        while (low <= high) {
            int testIndex = (low + high) >> 1;
            int curr = mountainArr.get(testIndex);

            if (curr == target) {
                return testIndex;
            } else if (curr < target) {
                low = testIndex + 1;
            } else {
                high = testIndex - 1;
            }
        }

        // 3. search in the strictly decreasing part of the array
        // if found, will be returned in the loop itself
        low = peakIndex + 1;
        high = length - 1;
        while (low <= high) {
            int testIndex = (low + high) >> 1;
            int curr = mountainArr.get(testIndex);

            if (curr == target) {
                return testIndex;
            } else if (curr > target) {
                low = testIndex + 1;
            } else {
                high = testIndex - 1;
            }
        }

        // target is not present in the mountain array
        return -1;
    }
}
