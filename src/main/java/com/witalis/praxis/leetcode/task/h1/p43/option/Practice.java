package com.witalis.praxis.leetcode.task.h1.p43.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 43
 * Name: Multiply Strings
 * URL: https://leetcode.com/problems/multiply-strings/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String number1;
    private String number2;

    public String process() {
        return multiply(number1, number2);
    }

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') return "0";

        StringBuilder builder = new StringBuilder();

        // to multiply by a shorter number
        char[] chars1 = (num1.length() >= num2.length()) ? num1.toCharArray() : num2.toCharArray();
        char[] chars2 = (num1.length() >= num2.length()) ? num2.toCharArray() : num1.toCharArray();

        // store single digit multiplication, list index is offset
        List<char[]> multiplications = new ArrayList<>();
        for (int i = chars2.length - 1; i >= 0; i--) {
            multiplications.add(
                chars2.length - 1 - i,
                multiplySingle(chars1, chars2[i])
            );
        }

        int counter = 0;
        int offset = 0;
        while (true) {
            int sum = offset;
            boolean exit = true;
            for (int i = 0; i < multiplications.size(); i++) {
                char[] multiplication = multiplications.get(i);
                if (counter - i >= 0 && counter - i < multiplication.length) {
                    sum += multiplication[counter - i] - '0';
                    exit = false;
                }
            }
            if (exit) {
                if (offset > 0) builder.append(offset);
                break;
            } else {
                builder.append(sum % 10);
                offset = sum / 10;
                counter++;
            }
        }

        return builder.reverse().toString();
    }

    /**
     * Multiply number as an array by a single digit.
     * <p/>
     * @param nums  a number represents as array of digits
     * @param digit a single digit for multiplication
     * @return the result of multiplication in array format
     */
    private char[] multiplySingle(char[] nums, char digit) {
        if (digit == '0') return new char[] {digit};

        StringBuilder builder = new StringBuilder();

        int offset = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = (nums[i] - '0') * (digit - '0') + offset;
            builder.append(num % 10);
            offset = num / 10;
        }
        if (offset > 0) builder.append(offset);

        return builder.toString().toCharArray();
    }
}
