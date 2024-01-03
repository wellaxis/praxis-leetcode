package com.witalis.praxis.leetcode.task.h27.p2610.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 2610
 * Name: Convert an Array Into a 2D Array With Conditions
 * URL: <a href="https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/">Convert an Array Into a 2D Array With Conditions</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] numbers;

    public List<List<Integer>> process() {
        return findMatrix(numbers);
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();

        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            if (answer.size() < ++count[num]) {
                answer.add(new ArrayList<>());
            }
            answer.get(count[num] - 1).add(num);
        }

        return answer;
    }
}
