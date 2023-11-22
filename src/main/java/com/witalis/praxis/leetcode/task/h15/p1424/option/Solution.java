package com.witalis.praxis.leetcode.task.h15.p1424.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 1424
 * Name: Diagonal Traverse II
 * URL: <a href="https://leetcode.com/problems/diagonal-traverse-ii/">Diagonal Traverse II</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<List<Integer>> numbers;

    public int[] process() {
        return findDiagonalOrder(numbers);
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);

            for (int j = 0; j < row.size(); j++) {
                int idx = i + j;

                if (lists.size() < idx + 1) {
                    lists.add(new ArrayList<>());
                }
                lists.get(idx).add(row.get(j));

                count ++;
            }
        }

        int[] res = new int[count];

        int idx = 0;
        for (List<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; i--) {
                res[idx++] = list.get(i);
            }
        }

        return res;
    }
}
