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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String preorder;

    public Boolean process() {
        return isValidSerialization(preorder);
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) return false;
        if (preorder.equals("#")) return true;

        Deque<Boolean> stack = new ArrayDeque<>();
        String[] values = preorder.split(",");
        for (String value : values) {
            if (value.equals("#")) {
                if (stack.isEmpty()) return false;
                while (!stack.isEmpty() && Boolean.TRUE.equals(!stack.peek())) stack.pop();
                if (!stack.isEmpty()) {
                    stack.pop();
                    stack.push(false);
                }
            } else {
                if (stack.isEmpty() && !value.equals(values[0])) return false;
                stack.push(true);
            }
        }

        return stack.isEmpty();
    }
}
