package com.witalis.praxis.leetcode.task.h29.p2810.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2810
 * Name: Faulty Keyboard
 * URL: <a href="https://leetcode.com/problems/faulty-keyboard/">Faulty Keyboard</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public String process() {
        return finalString(string);
    }

    public String finalString(String s) {
        char[] ans = new char[s.length()];
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'i') {
                reverse(ans, 0, k - 1);
            } else {
                ans[k++] = c;
            }
        }
        return new String(ans, 0, k);
    }

    public void reverse(char[] arr, int start, int end) {
        char temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
            start++;
        }
    }
}
