package com.witalis.praxis.leetcode.task.h21.p2024.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 2024
 * Name: Maximize the Confusion of an Exam
 * URL: <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/">Maximize the Confusion of an Exam</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String answerKey;
    private int times;

    public Integer process() {
        return maxConsecutiveAnswers(answerKey, times);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxSize = 0;
        Map<Character, Integer> count = new HashMap<>();

        for (int right = 0; right < answerKey.length(); right++) {
            count.put(answerKey.charAt(right), count.getOrDefault(answerKey.charAt(right), 0) + 1);
            int minor = Math.min(count.getOrDefault('T', 0), count.getOrDefault('F', 0));

            if (minor <= k) {
                maxSize++;
            } else {
                count.put(answerKey.charAt(right - maxSize), count.get(answerKey.charAt(right - maxSize)) - 1);
            }
        }

        return maxSize;
    }
}
