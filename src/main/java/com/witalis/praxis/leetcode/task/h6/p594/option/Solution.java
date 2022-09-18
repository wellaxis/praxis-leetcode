package com.witalis.praxis.leetcode.task.h6.p594.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 594
 * Name: Longest Harmonious Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-harmonious-subsequence/">Longest Harmonious Subsequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return findLHS(numbers);
    }

    public int findLHS(int[] nums) {

        Arrays.sort(nums);

        int len = nums.length;
        int ans = 0;
        int cntTemp = 0;
        int valTemp = 0;
        for (int i = 0; i < len; i++) {
            int cnt = 1;

            while (i < len - 1 && nums[i] == nums[i + 1]) {
                i++;
                cnt++;
            }

            if (i > 0 && nums[i] - valTemp <= 1) {
                ans = Math.max(ans, cnt + cntTemp);
            }

            cntTemp = cnt;
            valTemp = nums[i];
        }

        return cntTemp == len ? 0 : ans;
    }
}
