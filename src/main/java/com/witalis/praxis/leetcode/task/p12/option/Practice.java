package com.witalis.praxis.leetcode.task.p12.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 12
 * Name: Integer to Roman
 * URL: https://leetcode.com/problems/integer-to-roman/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private Integer number;

    public String process() {
        return intToRoman(number);
    }

    public String intToRoman(int num) {
        var result = "";

        int pow = 1;
        while (num > 0) {
            int digit = num % 10;

            result = getRoman(digit, pow) + result;

            num /= 10;
            pow++;
        }
        return result;
    }

    private String getRoman(int number, int pow) {
        return switch (number) {
            case 0 -> "";
            case 1 ->
                (pow == 1) ? "I" :
                    (pow == 2) ? "X" :
                        (pow == 3) ? "C" :
                            (pow == 4) ? "M" : "";
            case 2 ->
                (pow == 1) ? "II" :
                    (pow == 2) ? "XX" :
                        (pow == 3) ? "CC" :
                            (pow == 4) ? "MM" : "";
            case 3 ->
                (pow == 1) ? "III" :
                    (pow == 2) ? "XXX" :
                        (pow == 3) ? "CCC" :
                            (pow == 4) ? "MMM" : "";
            case 4 ->
                (pow == 1) ? "IV" :
                    (pow == 2) ? "XL" :
                        (pow == 3) ? "CD" :
                            (pow == 4) ? "MMMM" : "";
            case 5 ->
                (pow == 1) ? "V" :
                    (pow == 2) ? "L" :
                        (pow == 3) ? "D" :
                            (pow == 4) ? "MMMMM" : "";
            case 6 ->
                (pow == 1) ? "VI" :
                    (pow == 2) ? "LX" :
                        (pow == 3) ? "DC" :
                            (pow == 4) ? "MMMMMM" : "";
            case 7 ->
                (pow == 1) ? "VII" :
                    (pow == 2) ? "LXX" :
                        (pow == 3) ? "DCC" :
                            (pow == 4) ? "MMMMMMM" : "";
            case 8 ->
                (pow == 1) ? "VIII" :
                    (pow == 2) ? "LXXX" :
                        (pow == 3) ? "DCCC" :
                            (pow == 4) ? "MMMMMMMM" : "";
            case 9 ->
                (pow == 1) ? "IX" :
                    (pow == 2) ? "XC" :
                        (pow == 3) ? "CM" :
                            (pow == 4) ? "MMMMMMMMM" : "";
            default -> "";
        };
    }
}
