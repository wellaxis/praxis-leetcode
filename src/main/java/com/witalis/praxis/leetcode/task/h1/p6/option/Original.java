package com.witalis.praxis.leetcode.task.h1.p6.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * ID: 6
 * Name: Zigzag Conversion
 * URL: <a href="https://leetcode.com/problems/zigzag-conversion/">Zigzag Conversion</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private int numRows;

    public String process() {
        return convert(string, numRows);
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        Map<Integer, StringBuilder> map = new TreeMap<>(Comparator.naturalOrder());

        for (int i = 0; i < numRows; i++) {
            map.put(i, new StringBuilder());
        }

        int counter = 0;
        boolean down = true;
        int row = 0;

        while (counter < s.length()) {
            char ch = s.charAt(counter++);

            if (down) {
                if (row < numRows) {
                    map.computeIfPresent(row, (k, v) -> v.append(ch));
                    if (row + 1 < numRows) {
                        row++;
                    } else {
                        down = false;
                        row--;
                    }
                }
            } else {
                if (row >= 0) {
                    map.computeIfPresent(row, (k, v) -> v.append(ch));
                    if (row - 1 >= 0) {
                        row--;
                    } else {
                        down = true;
                        row++;
                    }
                }
            }
        }

        return map.values().stream()
            .reduce(
                new StringBuilder(),
                StringBuilder::append
            ).toString();
    }
}
