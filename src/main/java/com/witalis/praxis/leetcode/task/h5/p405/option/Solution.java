package com.witalis.praxis.leetcode.task.h5.p405.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 405
 * Name: Convert a Number to Hexadecimal
 * URL: <a href="https://leetcode.com/problems/convert-a-number-to-hexadecimal/">Convert a Number to Hexadecimal</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int number;

    public String process() {
        return toHex(number);
    }

    public String toHex(int num) {
        if (num == 0) return "0";

        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.append(map[(num & 15)]);
            num = (num >>> 4);
        }

        return reverse(result.toString().toCharArray());
    }

    private String reverse(char[] res) {
        int l = 0;
        int r = res.length - 1;

        while (r > l) {
            char temp = res[l];
            res[l] = res[r];
            res[r] = temp;
            l++;
            r--;
        }

        return String.valueOf(res);
    }
}
