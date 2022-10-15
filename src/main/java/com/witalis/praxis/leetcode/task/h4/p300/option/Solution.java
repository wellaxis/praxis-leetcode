package com.witalis.praxis.leetcode.task.h4.p300.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 300
 * Name: Longest Increasing Subsequence
 * URL: <a href="https://leetcode.com/problems/longest-increasing-subsequence/">Longest Increasing Subsequence</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public Integer process() {
        return lengthOfLIS(numbers);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    if (list.get(mid) < num) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                list.set(j, num);
            }
        }

        return list.size();
    }
}
