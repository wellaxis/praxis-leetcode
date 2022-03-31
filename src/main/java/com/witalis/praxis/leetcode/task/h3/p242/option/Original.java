package com.witalis.praxis.leetcode.task.h3.p242.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * ID: 242
 * Name: Valid Anagram
 * URL: https://leetcode.com/problems/valid-anagram/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String source;
    private String target;

    public Boolean process() {
        return isAnagram(source, target);
    }

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        var sMap = s.chars()
            .map(i -> (char) i)
            .boxed()
            .collect(groupingBy(identity(), counting()));
        var tMap = t.chars()
            .map(i -> (char) i)
            .boxed()
            .collect(groupingBy(identity(), counting()));

        return sMap.equals(tMap);
    }
}
