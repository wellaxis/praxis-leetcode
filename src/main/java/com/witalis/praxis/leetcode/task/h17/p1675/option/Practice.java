package com.witalis.praxis.leetcode.task.h17.p1675.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ID: 1675
 * Name: Minimize Deviation in Array
 * URL: <a href="https://leetcode.com/problems/minimize-deviation-in-array/">Minimize Deviation in Array</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] numbers;

    public Integer process() {
        return minimumDeviation(numbers);
    }

    public int minimumDeviation(int[] nums) {
        if (nums == null) return 0;

        final Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int minimum = Integer.MAX_VALUE;
        for (int num : nums) {
            if ((num & 1) != 0) num <<= 1;

            minimum = Math.min(minimum, num);
            queue.offer(num);
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
