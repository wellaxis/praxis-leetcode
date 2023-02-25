package com.witalis.praxis.leetcode.task.h8.p739.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 739
 * Name: Daily Temperatures
 * URL: <a href="https://leetcode.com/problems/daily-temperatures/">Daily Temperatures</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] temperatures;

    public int[] process() {
        return dailyTemperatures(temperatures);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return new int[0];

        final int len = temperatures.length;
        final int[] waitingDays = new int[len];
        final Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {temperatures[0], 0});

        for (int i = 1; i < len; i++) {
            int counter = 0;
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                counter++;
                int[] pop = stack.pop();
                waitingDays[i - (counter + pop[1])] = counter + pop[1];
            }
            if (!stack.isEmpty()) {
                for (int[] ints : stack) {
                    ints[1] += counter;
                }
            }
            stack.push(new int[] {temperatures[i], 0});
        }

        return waitingDays;
    }
}
