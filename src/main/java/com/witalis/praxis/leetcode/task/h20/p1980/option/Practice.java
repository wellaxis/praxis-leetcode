package com.witalis.praxis.leetcode.task.h20.p1980.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1980
 * Name: Find Unique Binary String
 * URL: <a href="https://leetcode.com/problems/find-unique-binary-string/">Find Unique Binary String</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] numbers;

    public String process() {
        return findDifferentBinaryString(numbers);
    }

    public String findDifferentBinaryString(String[] nums) {
        if (nums == null) return "";

        final int n = nums.length;
        var builder = new StringBuilder();
        for (int i = 0; i < n; i++)
            if (nums[i].toCharArray()[i] == '1')
                builder.append('0');
            else
                builder.append('1');

        return builder.toString();
    }
}
