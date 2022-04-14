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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int maxVersion;

    public Integer process() {
        return firstBadVersion(maxVersion);
    }

    public int firstBadVersion(int n) {
        if (n <= 1) return n;

        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (int) (((long) left + right) / 2);
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
