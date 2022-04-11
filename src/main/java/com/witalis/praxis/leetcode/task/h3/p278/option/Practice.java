package com.witalis.praxis.leetcode.task.h3.p278.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.task.h3.p278.content.VersionControl.isBadVersion;

/**
 * ID: 278
 * Name: First Bad Version
 * URL: https://leetcode.com/problems/first-bad-version/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int maxVersion;

    public Integer process() {
        return firstBadVersion(maxVersion);
    }

    public int firstBadVersion(int n) {
        return (n <= 1) ? n : recursiveSearch(1, n);
    }

    private int recursiveSearch(int left, int right) {
        if (left > right) return left;

        int mid = (int) (((long) left + right) / 2);
        if (isBadVersion(mid)) {
            return recursiveSearch(left, mid - 1);
        } else {
            return recursiveSearch(mid + 1, right);
        }
    }
}
