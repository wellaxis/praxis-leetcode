package com.witalis.praxis.leetcode.task.h17.p1675.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1675
 * Name: Minimize Deviation in Array
 * URL: <a href="https://leetcode.com/problems/minimize-deviation-in-array/">Minimize Deviation in Array</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] numbers;

    public Integer process() {
        return minimumDeviation(numbers);
    }

    public int minimumDeviation(int[] nums) {
        if (nums == null) return 0;

        Comparator<Integer> minimal = Integer::compareTo;
        final Queue<Integer> queue = new PriorityQueue<>(minimal.reversed());

        final int n = nums.length;
        int minimum = Integer.MAX_VALUE;
        for (int num : nums) {
            int value = num;
            if ((value & 1) != 0) {
                value <<= 1;
            }
            minimum = Math.min(minimum, value);
            queue.offer(value);
        }

        int deviation = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int maximum = queue.poll();
            deviation = Math.min(deviation, maximum - minimum);

            if ((maximum & 1) != 0) break;

            maximum /= 2;
            minimum = Math.min(minimum, maximum);
            queue.offer(maximum);
        }

        return deviation;
    }
}
