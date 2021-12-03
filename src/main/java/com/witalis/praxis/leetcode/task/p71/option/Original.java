package com.witalis.praxis.leetcode.task.p71.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;

/**
 * ID: 71
 * Name: Simplify Path
 * URL: https://leetcode.com/problems/simplify-path/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String path;

    public String process() {
        return simplifyPath(path);
    }

    public String simplifyPath(String path) {
        if (path == null || path.isBlank()) return "";
        if (path.charAt(0) != '/') return "";

        var canonical = new StringBuilder("/");
        ArrayDeque<String> stack = new ArrayDeque<>();

        var tokens = path.split("/");
        for (String token: tokens) {
            if (token.isEmpty() || token.equals(".")) {
                // ignore
            } else if (token.equals("..")) {
                if (stack.peekLast() != null) stack.removeLast();
            } else {
                stack.addLast(token);
            }
        }

        if (stack.isEmpty()) return canonical.toString();

        stack.forEach(token -> canonical.append(token).append("/"));
        var result = canonical.toString();

        return result.substring(0, result.length() - 1);
    }
}
