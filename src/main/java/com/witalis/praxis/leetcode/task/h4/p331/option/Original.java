package com.witalis.praxis.leetcode.task.h4.p331.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 331
 * Name: Verify Preorder Serialization of a Binary Tree
 * URL: <a href="https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/">Verify Preorder Serialization of a Binary Tree</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String preorder;

    public Boolean process() {
        return isValidSerialization(preorder);
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) return false;
        if (preorder.equals("#")) return true;

        Deque<Integer> stack = new ArrayDeque<>();
        String[] values = preorder.split(",");
        boolean initialised = false;
        for (String value : values) {
            if (value.equals("#")) {
                if (stack.isEmpty()) return false;
                while (!stack.isEmpty() && stack.peek() == 1) stack.pop();
                if (!stack.isEmpty() && stack.peek() == 2) {
                    stack.push(stack.pop() - 1);
                }
            } else {
                if (initialised && stack.isEmpty()) return false;
                stack.push(2);
                initialised = true;
            }
        }

        return stack.isEmpty();
    }
}
