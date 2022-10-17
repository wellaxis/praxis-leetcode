package com.witalis.praxis.leetcode.task.h4.p306.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

/**
 * ID: 306
 * Name: Additive Number
 * URL: <a href="https://leetcode.com/problems/additive-number/">Additive Number</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String number;

    public Boolean process() {
        return isAdditiveNumber(number);
    }

    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;

        BigInteger previous2;
        BigInteger previous1;
        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(0) == '0' && !num.substring(0, i).equals("0")) continue;
                previous2 = new BigInteger(num.substring(0, i));

                if (num.charAt(i) == '0' && !num.substring(i, j).equals("0")) continue;
                previous1 = new BigInteger(num.substring(i, j));

                if (dfs(num.substring(j), previous2, previous1)) return true;
            }
        }

        return false;
    }

    private boolean dfs(String num, BigInteger previous2, BigInteger previous1) {
        if (num.length() == 0) return true;

        BigInteger current;
        for (int i = 1; i <= num.length(); i++) {
            if (num.charAt(0) == '0' && !num.substring(0, i).equals("0")) continue;
            current = new BigInteger(num.substring(0, i));

            if (current.compareTo(previous2.add(previous1)) > 0) break;
            if (current.equals(previous2.add(previous1)) && dfs(num.substring(i), previous1, current)) return true;
        }

        return false;
    }
}
