package com.witalis.praxis.leetcode.task.h10.p946.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 946
 * Name: Validate Stack Sequences
 * URL: <a href="https://leetcode.com/problems/validate-stack-sequences/">Validate Stack Sequences</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] pushed;
    private int[] popped;

    public Boolean process() {
        return validateStackSequences(pushed, popped);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) return false;

        final int pushLen = pushed.length;
        final int popLen = popped.length;

        if (pushLen != popLen) return false;

        final Deque<Integer> stack = new ArrayDeque<>(pushLen);

        int popIndex = 0;
        for (final int pushInt : pushed) {
            stack.push(pushInt);
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
}
