package com.witalis.praxis.leetcode.task.h1.p38.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 38
 * Name: Count and Say
 * URL: https://leetcode.com/problems/count-and-say/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int number;

    public String process() {
        return countAndSay(number);
    }

    public String countAndSay(int n) {
        if (n <= 0) return null;

        String result = "1";
        if (n == 1) return result;
        n--;

        while (n > 0) {
            result = countAndSay(result);
            n--;
        }
        return result;
    }

    private String countAndSay(String result) {
        StringBuilder builder = new StringBuilder();

        int counter = 0;
        char previous = 0;
        for (char digit: result.toCharArray()) {
            if (counter == 0) {
                previous = digit;
                counter++;
            } else {
                if (previous == digit) {
                    counter++;
                } else {
                    builder.append(counter).append(previous);
                    previous = digit;
                    counter = 1;
                }
            }
        }

        builder.append(counter).append(previous);
        return builder.toString();
    }

    private String countAndSayRegex(String result) {
        String[] groups = result.split("(?<=(.))(?!\\1)");

        StringBuilder builder = new StringBuilder();
        for (String group: groups) {
            builder.append(group.length()).append(group.charAt(0));
        }

        return builder.toString();
    }
}
