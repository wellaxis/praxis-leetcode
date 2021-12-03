package com.witalis.praxis.leetcode.task.p12.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 12
 * Name: Integer to Roman
 * URL: https://leetcode.com/problems/integer-to-roman/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private Integer number;

    public String process() {
        return intToRoman(number);
    }

    public String intToRoman(int num) {
        var result = "";

        int pow = 1;
        while (num > 0) {
            int digit = num % 10;

            switch (digit) {
                case 0 -> result = "" + result;
                case 1 -> {
                    if (pow == 1) result = "I" + result;
                    else if (pow == 2) result = "X" + result;
                    else if (pow == 3) result = "C" + result;
                    else if (pow == 4) result = "M" + result;
                }
                case 2 -> {
                    if (pow == 1) result = "II" + result;
                    else if (pow == 2) result = "XX" + result;
                    else if (pow == 3) result = "CC" + result;
                    else if (pow == 4) result = "MM" + result;
                }
                case 3 -> {
                    if (pow == 1) result = "III" + result;
                    else if (pow == 2) result = "XXX" + result;
                    else if (pow == 3) result = "CCC" + result;
                    else if (pow == 4) result = "MMM" + result;
                }
                case 4 -> {
                    if (pow == 1) result = "IV" + result;
                    else if (pow == 2) result = "XL" + result;
                    else if (pow == 3) result = "CD" + result;
                    else if (pow == 4) result = "MMMM" + result;
                }
                case 5 -> {
                    if (pow == 1) result = "V" + result;
                    else if (pow == 2) result = "L" + result;
                    else if (pow == 3) result = "D" + result;
                    else if (pow == 4) result = "MMMMM" + result;
                }
                case 6 -> {
                    if (pow == 1) result = "VI" + result;
                    else if (pow == 2) result = "LX" + result;
                    else if (pow == 3) result = "DC" + result;
                    else if (pow == 4) result = "MMMMMM" + result;
                }
                case 7 -> {
                    if (pow == 1) result = "VII" + result;
                    else if (pow == 2) result = "LXX" + result;
                    else if (pow == 3) result = "DCC" + result;
                    else if (pow == 4) result = "MMMMMMM" + result;
                }
                case 8 -> {
                    if (pow == 1) result = "VIII" + result;
                    else if (pow == 2) result = "LXXX" + result;
                    else if (pow == 3) result = "DCCC" + result;
                    else if (pow == 4) result = "MMMMMMMM" + result;
                }
                case 9 -> {
                    if (pow == 1) result = "IX" + result;
                    else if (pow == 2) result = "XC" + result;
                    else if (pow == 3) result = "CM" + result;
                    else if (pow == 4) result = "MMMMMMMMM" + result;
                }
                default -> throw new IllegalArgumentException("It is not an Integer symbol: " + digit);
            }

            num /= 10;
            pow++;
        }
        return result;
    }
}
