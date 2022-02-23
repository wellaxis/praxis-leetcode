package com.witalis.praxis.leetcode.task.h2.p168.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 168
 * Name: Excel Sheet Column Title
 * URL: https://leetcode.com/problems/excel-sheet-column-title/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    public static final Map<Integer, String> LETTERS = new HashMap<>() {{
        put(1, "A"); put(2, "B"); put(3, "C"); put(4, "D"); put(5, "E");
        put(6, "F"); put(7, "G"); put(8, "H"); put(9, "I"); put(10, "J");
        put(11, "K"); put(12, "L"); put(13, "M"); put(14, "N");
        put(15, "O"); put(16, "P"); put(17, "Q"); put(18, "R");
        put(19, "S"); put(20, "T"); put(21, "U"); put(22, "V");
        put(23, "W"); put(24, "X"); put(25, "Y"); put(26, "Z");
    }};
    private int columnNumber;

    public String process() {
        return convertToTitle(columnNumber);
    }

    public String convertToTitle(int columnNumber) {
        if (columnNumber < 1) return "";

        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            if (columnNumber % 26 == 0) {
                builder.append(LETTERS.get(26));
                columnNumber /= 26;
                columnNumber--;
            } else {
                builder.append(LETTERS.get(columnNumber % 26));
                columnNumber /= 26;
            }
        }

        return builder.reverse().toString();
    }
}
