package com.witalis.praxis.leetcode.task.h14.p1323.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1323
 * Name: Maximum 69 Number
 * URL: <a href="https://leetcode.com/problems/maximum-69-number/">Maximum 69 Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public Integer process() {
        return maximum69Number(number);
    }

    public int maximum69Number (int num) {
        if (num <= 0) return num;

        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }
}
