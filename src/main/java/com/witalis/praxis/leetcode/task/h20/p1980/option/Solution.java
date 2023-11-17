package com.witalis.praxis.leetcode.task.h20.p1980.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1980
 * Name: Find Unique Binary String
 * URL: <a href="https://leetcode.com/problems/find-unique-binary-string/">Find Unique Binary String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] numbers;

    public String process() {
        return findDifferentBinaryString(numbers);
    }

    // Cantor's Diagonal Argument
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            char curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }

        return ans.toString();
    }
}
