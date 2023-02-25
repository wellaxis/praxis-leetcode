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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private int[] temperatures;

    public int[] process() {
        return dailyTemperatures(temperatures);
    }

    record Element(int value, int index) {}

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) return new int[0];

        final Deque<Element> elements = new ArrayDeque<>();

        final int n = temperatures.length;
        final int[] answers = new int[n];
        for (int i = 0; i < n; i++) {
            final int temperature = temperatures[i];
            while (!elements.isEmpty() && temperature > elements.peek().value) {
                Element previous = elements.pop();
                answers[previous.index] = i - previous.index;
            }
            elements.push(new Element(temperature, i));
        }

        return answers;
    }
}
