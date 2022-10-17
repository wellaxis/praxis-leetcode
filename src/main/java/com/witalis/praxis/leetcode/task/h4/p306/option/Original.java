package com.witalis.praxis.leetcode.task.h4.p306.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 306
 * Name: Additive Number
 * URL: <a href="https://leetcode.com/problems/additive-number/">Additive Number</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String number;

    public Boolean process() {
        return isAdditiveNumber(number);
    }

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;

        int len = num.length();
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                long prev2 = parse(num.substring(0, i));
                long prev1 = parse(num.substring(i, j));

                if (prev2 == -1 || prev1 == -1) continue;
                if (dfs(num.substring(j), prev2, prev1)) return true;
            }
        }

        return false;
    }

    private boolean dfs(String num, long prev2, long prev1) {
        if (num.length() == 0) return true;

        for (int i = 1; i <= num.length(); i++) {
            long current = parse(num.substring(0, i));
            if (current < 0) continue;
            if (current == prev2 + prev1 && dfs(num.substring(i), prev1, current)) return true;
        }

        return false;
    }

    private long parse(String s) {
        if (!s.equals("0") && s.startsWith("0")) return -1;

        long num;
        try {
            num = Long.parseLong(s);
        } catch (NumberFormatException e) {
            return -1;
        }

        return num;
    }
}
