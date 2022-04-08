package com.witalis.praxis.leetcode.task.h3.p228.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 228
 * Name: Summary Ranges
 * URL: https://leetcode.com/problems/summary-ranges/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<String> process() {
        return summaryRanges(numbers);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        int i = 0;
        int n = nums.length;
        while (i < n) {
            int start;
            int end;

            start = nums[i];
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) i++;
            end = nums[i];

            if (start == end) {
                res.add(start + "");
            } else {
                res.add(start + "->" + end);
            }

            i++;
        }

        return res;
    }
}
