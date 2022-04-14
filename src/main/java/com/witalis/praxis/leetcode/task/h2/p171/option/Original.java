package com.witalis.praxis.leetcode.task.h2.p171.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 171
 * Name: Excel Sheet Column Number
 * URL: <a href="https://leetcode.com/problems/excel-sheet-column-number/">Excel Sheet Column Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    public static final Map<String, Integer> LETTERS = new HashMap<>() {{
        put("A", 1); put("B", 2); put("C", 3); put("D", 4); put("E", 5);
        put("F", 6); put("G", 7); put("H", 8); put("I", 9); put("J", 10);
        put("K", 11); put("L", 12); put("M", 13); put("N", 14);
        put("O", 15); put("P", 16); put("Q", 17); put("R", 18);
        put("S", 19); put("T", 20); put("U", 21); put("V", 22);
        put("W", 23); put("X", 24); put("Y", 25); put("Z", 26);
    }};
    private String columnTitle;

    public Integer process() {
        return titleToNumber(columnTitle);
    }

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) return 0;

        int number = 0;

        int len = columnTitle.length();
        for (int i = len; i > 0; i--) {
            char ch = columnTitle.charAt(len - i);
            int base = LETTERS.get(String.valueOf(ch));
            int value = (i > 1) ? (int) Math.pow(26, i - 1D) * base : base;
            number += value;
        }

        return number;
    }
}
