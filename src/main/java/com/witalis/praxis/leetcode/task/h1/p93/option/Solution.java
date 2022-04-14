package com.witalis.praxis.leetcode.task.h1.p93.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 93
 * Name: Restore IP Addresses
 * URL: <a href="https://leetcode.com/problems/restore-ip-addresses/">Restore IP Addresses</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String string;

    public List<String> process() {
        return restoreIpAddresses(string);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtracking(0, s, new ArrayList<>(), result);

        return result;
    }

    private void backtracking(int d, String s, List<Integer> build, List<String> result) {
        // base case
        if (build.size() == 4) {
            // add to the result
            if (d >= s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < build.size(); ++i) {
                    sb.append(build.get(i));
                    if (i < build.size() - 1) sb.append(".");
                }
                result.add(sb.toString());
            }
            return;
        }

        // check the first num if it is "0"
        if (d >= s.length()) return;
        int firstNum = s.charAt(d) - '0';
        int count = (firstNum == 0) ? 1 : 3;
        int sum = 0;
        for (int i = 0; i < count; ++i) {
            if (d + i >= s.length()) break;
            int digit = s.charAt(d + i) - '0';
            sum = sum * 10 + digit;
            if (sum >= 0 && sum <= 255) {
                build.add(sum);
                backtracking(d + i + 1, s, build, result);
                build.remove(build.size() - 1);
            }
        }
    }
}
