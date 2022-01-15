package com.witalis.praxis.leetcode.task.h1.p38.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 38
 * Name: Count and Say
 * URL: https://leetcode.com/problems/count-and-say/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int number;

    public String process() {
        return countAndSay(number);
    }

    public String countAndSay(int n) {
        if (n < 1) return null;

        String result = "1";
        if (n == 1) return result;
        n--;

        while (n > 0) {
            result = countAndSay(result);
            n--;
        }
        return result;
    }

    private String countAndSay(String n) {
        StringBuilder result = new StringBuilder();

        int counter = 0;
        Character previous = null;
        for (char digit: n.toCharArray()) {
            if (previous == null) {
                previous = digit;
                counter++;
            } else {
                if (previous == digit) {
                    counter++;
                } else {
                    result.append(counter).append(previous);
                    previous = digit;
                    counter = 1;
                }
            }
        }

        result.append(counter).append(previous);

        return result.toString();
    }
}
