package com.witalis.praxis.leetcode.task.h1.p67.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 67
 * Name: Add Binary
 * URL: <a href="https://leetcode.com/problems/add-binary/">Add Binary</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String binary1;
    private String binary2;

    public String process() {
        return addBinary(binary1, binary2);
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        var result = new StringBuilder();

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int index = 0;
        int offset = 0;
        while (index < Math.min(a.length(), b.length())) {
            int sum = offset
                + a.charAt(index) - '0'
                + b.charAt(index) - '0';

            offset = (sum > 1) ? 1 : 0;

            if (sum % 2 == 0) {
                result.append('0');
            } else {
                result.append('1');
            }

            index++;
        }

        var tail = (a.length() > b.length())
            ? a.substring(index)
            : b.substring(index);

        if (offset == 0) {
            result.append(tail);
        } else {
            index = tail.indexOf('0');
            if (index < 0) {
                result
                    .append("0".repeat(tail.length()))
                    .append('1');
            } else {
                result
                    .append("0".repeat(index))
                    .append('1')
                    .append(tail.substring(index + 1));
            }
        }

        return result.reverse().toString();
    }
}
