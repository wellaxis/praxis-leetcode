package com.witalis.praxis.leetcode.task.h15.p1441.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 1441
 * Name: Build an Array With Stack Operations
 * URL: <a href="https://leetcode.com/problems/build-an-array-with-stack-operations/">Build an Array With Stack Operations</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private int[] target;
    private int number;

    public List<String> process() {
        return buildArray(target, number);
    }

    public List<String> buildArray(int[] target, int n) {
        if (target == null || n <= 0) return Collections.emptyList();

        List<String> operations = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        int count = 1;
        do {
            stack.push(count);
            operations.add("Push");
            count++;

            if (stack.peek() == target[index]) {
                index++;
            } else {
                stack.pop();
                operations.add("Pop");
            }

        } while (index != target.length);

        return operations;
    }
}
