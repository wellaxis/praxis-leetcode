package com.witalis.praxis.leetcode.task.h3.p278.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.task.h3.p278.content.VersionControl.isBadVersion;

/**
 * ID: 278
 * Name: First Bad Version
 * URL: <a href="https://leetcode.com/problems/first-bad-version/">First Bad Version</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int maxVersion;

    public Integer process() {
        return firstBadVersion(maxVersion);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (isBadVersion(left)) {
            return left;
        }
        return left + 1;
    }
}
