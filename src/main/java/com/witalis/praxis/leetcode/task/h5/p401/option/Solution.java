package com.witalis.praxis.leetcode.task.h5.p401.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 401
 * Name: Binary Watch
 * URL: <a href="https://leetcode.com/problems/binary-watch/">Binary Watch</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int turnedOn;

    public List<String> process() {
        return readBinaryWatch(turnedOn);
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m <= 59; m++) {
                int count = Integer.bitCount(h) + Integer.bitCount(m);
                if (count == turnedOn) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(h).append(":");
                    if (m < 10) sb.append("0");
                    sb.append(m);
                    ans.add(sb.toString());
                } else if (count < turnedOn) {
                    m = (int) (m + Math.pow(2, turnedOn - count) - 1) - 1;
                }
            }
        }

        return ans;
    }
}
