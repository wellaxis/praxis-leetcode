package com.witalis.praxis.leetcode.task.h21.p2024.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2024
 * Name: Maximize the Confusion of an Exam
 * URL: <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/">Maximize the Confusion of an Exam</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String answerKey;
    private int times;

    public Integer process() {
        return maxConsecutiveAnswers(answerKey, times);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        if (answerKey == null || answerKey.isEmpty()) return 0;

        final char[] keys = answerKey.toCharArray();

        return Math.max(
            maxConsecutiveOption(keys, k, 'T'),
            maxConsecutiveOption(keys, k, 'F')
        );
    }

    private int maxConsecutiveOption(char[] keys, int times, char option) {
        int max = 0;

        int slow = 0;
        int fast = 0;
        int changes = 0;
        while (fast < keys.length) {
            if (keys[fast] == option) {
                changes++;
                while (changes > times) {
                    if (keys[slow] == option) changes--;
                    slow++;
                }
            }
            max = Math.max(max, fast - slow + 1);
            fast++;
        }

        return max;
    }
}
