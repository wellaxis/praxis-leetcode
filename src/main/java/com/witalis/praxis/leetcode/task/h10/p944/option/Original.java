package com.witalis.praxis.leetcode.task.h10.p944.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 944
 * Name: Delete Columns to Make Sorted
 * URL: <a href="https://leetcode.com/problems/delete-columns-to-make-sorted/">Delete Columns to Make Sorted</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] strings;

    public Integer process() {
        return minDeletionSize(strings);
    }

    public int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) return 0;

        int columns = 0;

        int num = strs.length;
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < num; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    columns++;
                    break;
                }
            }
        }

        return columns;
    }
}
