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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<List<Integer>> numbers;

    public int[] process() {
        return findDiagonalOrder(numbers);
    }

    record Cell(int weight, int row, int col, int value) {}

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums == null) return new int[0];

        Queue<Cell> heap = new PriorityQueue<>(cellComparator());

        int rows = nums.size();
        for (int r = 0; r < rows; r++) {
            List<Integer> row = nums.get(r);

            int cols = row.size();
            for (int c = 0; c < cols; c++) {
                int value = row.get(c);

                heap.offer(new Cell(r + c, r, c, value));
            }
        }

        List<Integer> numbers = new ArrayList<>();
        while (!heap.isEmpty())
            numbers.add(heap.poll().value());

        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Comparator<Cell> cellComparator() {
        return (c1, c2) -> {
            if (c1.weight() == c2.weight())
                return c2.row() - c1.row();
            return c1.weight() - c2.weight();
        };
    }
}
