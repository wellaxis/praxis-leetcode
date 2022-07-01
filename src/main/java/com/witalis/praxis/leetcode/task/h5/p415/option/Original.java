package com.witalis.praxis.leetcode.task.h5.p415.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 415
 * Name: Add Strings
 * URL: <a href="https://leetcode.com/problems/add-strings/">Add Strings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String number1;
    private String number2;

    public String process() {
        return addStrings(number1, number2);
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;

        StringBuilder builder = new StringBuilder();
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;

        int d1;
        int d2;
        int dc = 0;
        while (n1 >= 0 && n2 >= 0) {
            d1 = num1.charAt(n1) - '0';
            d2 = num2.charAt(n2) - '0';
            builder.append((d1 + d2 + dc) % 10);
            dc = (d1 + d2 + dc) / 10;
            n1--;
            n2--;
        }
        while (n1 >= 0) {
            d1 = num1.charAt(n1) - '0';
            builder.append((d1 + dc) % 10);
            dc = (d1 + dc) / 10;
            n1--;
        }
        while (n2 >= 0) {
            d2 = num2.charAt(n2) - '0';
            builder.append((d2 + dc) % 10);
            dc = (d2 + dc) / 10;
            n2--;
        }

        if (dc != 0) builder.append(dc);

        return builder.reverse().toString();
    }
}
