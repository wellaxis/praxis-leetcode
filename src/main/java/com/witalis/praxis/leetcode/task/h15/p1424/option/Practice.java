package com.witalis.praxis.leetcode.task.h15.p1424.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1424
 * Name: Diagonal Traverse II
 * URL: <a href="https://leetcode.com/problems/diagonal-traverse-ii/">Diagonal Traverse II</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<List<Integer>> numbers;

    public int[] process() {
        return findDiagonalOrder(numbers);
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null) return new int[0];

        Queue<int[]> heap = new PriorityQueue<>((c1, c2) -> (c1[0] == c2[0]) ? c2[1] - c1[1] : c1[0] - c2[0]);

        int rows = nums.size();
        for (int r = 0; r < rows; r++) {
            List<Integer> row = nums.get(r);

            int cols = row.size();
            for (int c = 0; c < cols; c++) {
                int value = row.get(c);

                heap.offer(new int[] {r + c, r, c, value});
            }
        }

        int[] numbers = new int[heap.size()];

        int counter = 0;
        while (!heap.isEmpty())
            numbers[counter++] = heap.poll()[3];

        return numbers;
    }
}
