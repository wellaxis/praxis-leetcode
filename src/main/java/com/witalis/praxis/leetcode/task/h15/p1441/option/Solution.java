package com.witalis.praxis.leetcode.task.h15.p1441.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 1441
 * Name: Build an Array With Stack Operations
 * URL: <a href="https://leetcode.com/problems/build-an-array-with-stack-operations/">Build an Array With Stack Operations</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] target;
    private int number;

    public List<String> process() {
        return buildArray(target, number);
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList();

        int i = 0;
        for (int num : target) {
            while (i < num - 1) {
                ans.add("Push");
                ans.add("Pop");
                i++;
            }

            ans.add("Push");
            i++;
        }

        return ans;
    }
}
