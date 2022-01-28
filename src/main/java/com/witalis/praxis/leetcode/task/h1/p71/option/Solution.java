package com.witalis.praxis.leetcode.task.h1.p71.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * ID: 71
 * Name: Simplify Path
 * URL: https://leetcode.com/problems/simplify-path/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String path;

    public String process() {
        return simplifyPath(path);
    }

    public String simplifyPath(String path) {
        if (path.equals("/"))
            return path;
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("") || strings[i].equals("."))
                continue;
            else if (strings[i].equals("..")) {
                if (stack.size() > 0)
                    stack.pop();
            } else
                stack.push(strings[i]);
        }
        if (stack.isEmpty())
            return "/";
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }
}
