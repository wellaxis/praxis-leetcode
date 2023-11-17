package com.witalis.praxis.leetcode.task.h20.p1980.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1980
 * Name: Find Unique Binary String
 * URL: <a href="https://leetcode.com/problems/find-unique-binary-string/">Find Unique Binary String</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] numbers;

    public String process() {
        return findDifferentBinaryString(numbers);
    }

    public String findDifferentBinaryString(String[] nums) {
        if (nums == null) return "";

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            String num = nums[i];
            char[] digits = num.toCharArray();
            char digit = digits[i];

            if (digit == '1') {
                builder.append('0');
            } else {
                builder.append('1');
            }
        }

        return builder.toString();
    }
}
