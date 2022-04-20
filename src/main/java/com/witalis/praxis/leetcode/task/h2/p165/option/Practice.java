package com.witalis.praxis.leetcode.task.h2.p165.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 165
 * Name: Compare Version Numbers
 * URL: <a href="https://leetcode.com/problems/compare-version-numbers/">Compare Version Numbers</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String version1;
    private String version2;

    public Integer process() {
        return compareVersion(version1, version2);
    }

    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null)
            throw new IllegalArgumentException("Incorrect version values");

        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");

        int length = Math.max(revisions1.length, revisions2.length);
        int index = 0;
        while (index < length) {
            int revision1 = (index < revisions1.length) ? Integer.parseInt(revisions1[index]) : 0;
            int revision2 = (index < revisions2.length) ? Integer.parseInt(revisions2[index]) : 0;

            int compare = Integer.compare(revision1, revision2);
            if (compare != 0) return compare;

            index++;
        }

        return 0;
    }
}
