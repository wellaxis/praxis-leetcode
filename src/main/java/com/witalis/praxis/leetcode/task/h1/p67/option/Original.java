package com.witalis.praxis.leetcode.task.h1.p67.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 67
 * Name: Add Binary
 * URL: https://leetcode.com/problems/add-binary/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
        while (index < Math.max(a.length(), b.length())) {
            int ai = (index < a.length()) ? a.charAt(index) - '0' : 0;
            int bi = (index < b.length()) ? b.charAt(index) - '0' : 0;

            int sum = ai + bi + offset;
            offset = (sum > 1) ? 1 : 0;

            if (sum % 2 == 0) {
                result.append('0');
            } else {
                result.append('1');
            }

            index++;
        }
        if (offset == 1) result.append('1');

        return result.reverse().toString();
    }
}
