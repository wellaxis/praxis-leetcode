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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int target;
    private MountainArray mountainArray;

    public Integer process() {
        return findInMountainArray(target, mountainArray);
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (target < 0 || mountainArr == null) return 0;

        final int n = mountainArr.length();

        int left = 1;
        int right = n - 2;
        int mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        int maxPosition = left;
        left = 0;
        right = maxPosition;
        int element;
        while (left <= right) {
            mid = left + (right - left) / 2;

            element = mountainArr.get(mid);
            if (element == target) return mid;
            if (element > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = maxPosition;
        right = n - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;

            element = mountainArr.get(mid);
            if (element == target) return mid;
            if (element < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
