package com.witalis.praxis.leetcode.task.h10.p912.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ID: 912
 * Name: Sort an Array
 * URL: <a href="https://leetcode.com/problems/sort-an-array/">Sort an Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public int[] process() {
        return sortArray(numbers);
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) return nums;

        final Queue<int[]> queue = new ArrayDeque<>();

        for (final int num : nums) queue.offer(new int[] {num});

        while (!queue.isEmpty() && queue.size() > 1) {
            queue.offer(merge(queue.poll(), queue.poll()));
        }

        return queue.poll();
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        final int n1 = arr1.length;
        final int n2 = arr2.length;

        final int[] arr = new int[n1 + n2];

        int i = 0;
        int i1 = 0;
        int i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (arr1[i1] <= arr2[i2]) {
                arr[i++] = arr1[i1++];
            } else {
                arr[i++] = arr2[i2++];
            }
        }
        while (i1 < n1) arr[i++] = arr1[i1++];
        while (i2 < n2) arr[i++] = arr2[i2++];

        return arr;
    }
}
