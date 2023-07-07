package com.witalis.praxis.leetcode.task.h21.p2024.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2024
 * Name: Maximize the Confusion of an Exam
 * URL: <a href="https://leetcode.com/problems/maximize-the-confusion-of-an-exam/">Maximize the Confusion of an Exam</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String answerKey;
    private int times;

    public Integer process() {
        return maxConsecutiveAnswers(answerKey, times);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        if (answerKey == null || answerKey.isEmpty()) return 0;

        final int n = answerKey.length();

        int max = 0;

        // consecutive true
        int slow = 0;
        int fast = 0;
        int extra = 0;
        while (fast < n) {
            if (answerKey.charAt(fast) == 'F') {
                extra++;
                while (extra > k) {
                    if (answerKey.charAt(slow) == 'F') extra--;
                    slow++;
                }
            }
            max = Math.max(max, fast - slow + 1);
            fast++;
        }

        // consecutive false
        slow = 0;
        fast = 0;
        extra = 0;
        while (fast < n) {
            if (answerKey.charAt(fast) == 'T') {
                extra++;
                while (extra > k) {
                    if (answerKey.charAt(slow) == 'T') extra--;
                    slow++;
                }
            }
            max = Math.max(max, fast - slow + 1);
            fast++;
        }

        return max;
    }
}
