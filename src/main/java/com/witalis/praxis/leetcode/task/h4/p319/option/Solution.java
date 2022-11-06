package com.witalis.praxis.leetcode.task.h4.p319.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 319
 * Name: Bulb Switcher
 * URL: <a href="https://leetcode.com/problems/bulb-switcher/">Bulb Switcher</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public Integer process() {
        return bulbSwitch(number);
    }

    public int bulbSwitch(int n) {
        int on = 0;
        for (int i = 1; i * i <= n; i++) on++;

        return on;
    }
}
