package com.witalis.praxis.leetcode.task.h10.p946.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 946
 * Name: Validate Stack Sequences
 * URL: <a href="https://leetcode.com/problems/validate-stack-sequences/">Validate Stack Sequences</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private int[] pushed;
    private int[] popped;

    public Boolean process() {
        return validateStackSequences(pushed, popped);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int push = -1;
        int pop = 0;
        for (int i : pushed) {
            pushed[++push] = i;
            for (; push >= 0 && pop < n && pushed[push] == popped[pop]; push--, pop++);
        }

        return push < 0;
    }
}
