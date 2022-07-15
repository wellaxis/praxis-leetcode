package com.witalis.praxis.leetcode.task.h5.p459.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 459
 * Name: Repeated Substring Pattern
 * URL: <a href="https://leetcode.com/problems/repeated-substring-pattern/">Repeated Substring Pattern</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public Boolean process() {
        return repeatedSubstringPattern(string);
    }

    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.isEmpty()) return false;

        int len = s.length();
        Set<Character> letters = new HashSet<>();
        for (int i = 0; i < len; i++) letters.add(s.charAt(i));

        int size = letters.size();
        if (size == len) return false;
        if (size == 1) return true;

        for (; size < len; size++) {
            if (len % size != 0) continue;
            if (s.equals(s.substring(0, size).repeat(len / size))) return true;
        }

        return false;
    }
}
