package com.witalis.praxis.leetcode.task.h24.p2391.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2391
 * Name: Minimum Amount of Time to Collect Garbage
 * URL: <a href="https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/">Minimum Amount of Time to Collect Garbage</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] garbage;
    private int[] travel;

    public Integer process() {
        return garbageCollection(garbage, travel);
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += 3 * travel[i];
        }

        for (String s : garbage) {
            ans += s.length();
        }

        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("G")) {
                ans -= travel[i - 1];
            } else {
                break;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("P")) {
                ans -= travel[i - 1];
            } else {
                break;
            }
        }

        for (int i = n - 1; i > 0; i--) {
            if (!garbage[i].contains("M")) {
                ans -= travel[i - 1];
            } else {
                break;
            }
        }

        return ans;
    }
}
