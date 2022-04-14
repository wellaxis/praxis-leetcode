package com.witalis.praxis.leetcode.task.h1.p71.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ID: 71
 * Name: Simplify Path
 * URL: <a href="https://leetcode.com/problems/simplify-path/">Simplify Path</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String path;

    public String process() {
        return simplifyPath(path);
    }

    public String simplifyPath(String path) {
        if (path == null || path.isBlank()) return "";
        if (path.charAt(0) != '/') return "";

        Deque<String> stack = new ArrayDeque<>();

        for (String token: path.split("/")) {
            switch (token) {
                case "", "." -> {
                }
                case ".." -> {
                    if (!stack.isEmpty()) stack.removeLast();
                }
                default -> {
                    stack.addLast("/" + token);
                }
            }
        }

        if (stack.isEmpty()) return "/";

        var canonical = new StringBuilder();
        stack.forEach(canonical::append);

        return canonical.toString();
    }
}
