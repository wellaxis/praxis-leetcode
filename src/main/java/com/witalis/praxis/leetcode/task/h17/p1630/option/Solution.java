package com.witalis.praxis.leetcode.task.h17.p1630.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 1630
 * Name: Arithmetic Subarrays
 * URL: <a href="https://leetcode.com/problems/arithmetic-subarrays/">Arithmetic Subarrays</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;
    private int[] left;
    private int[] right;

    public List<Boolean> process() {
        return checkArithmeticSubarrays(numbers, left, right);
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            if (r[i] - l[i] < 2) res.add(true);
            else {
                int minNum = minNum(nums, l[i], r[i]);
                int maxNum = maxNum(nums, l[i], r[i]);
                int diff = maxNum - minNum;
                int countDiff = r[i] - l[i];
                if (minNum == maxNum) res.add(true);
                else if (diff % countDiff != 0) res.add(false);
                else {
                    int d = diff / countDiff;
                    boolean[] mark = new boolean[r[i] - l[i] + 1];
                    boolean flag = true;
                    for (int p = l[i]; p <= r[i]; p++) {
                        if ((nums[p] - minNum) % d != 0) {
                            flag = false;
                            break;
                        }
                        if (mark[(nums[p] - minNum) / d]) {
                            flag = false;
                            break;
                        } else {
                            mark[(nums[p] - minNum) / d] = true;
                        }
                    }
                    res.add(flag);
                }
            }
        }

        return res;
    }

    public int minNum(int[] nums, int left, int right) {
        int ans = nums[left];
        for (int i = left; i <= right; i++) {
            ans = Math.min(ans, nums[i]);
        }
        return ans;
    }

    public int maxNum(int[] nums, int left, int right) {
        int ans = nums[left];
        for (int i = left; i <= right; i++) {
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }
}
