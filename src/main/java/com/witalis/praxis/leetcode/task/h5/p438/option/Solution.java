package com.witalis.praxis.leetcode.task.h5.p438.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 438
 * Name: Find All Anagrams in a String
 * URL: <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string/">Find All Anagrams in a String</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String source;
    private String pattern;

    public List<Integer> process() {
        return findAnagrams(source, pattern);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[128];
        int required = p.length();

        for (final char c : p.toCharArray())
            ++count[c];

        for (int l = 0, r = 0; r < s.length(); ++r) {
            if (--count[s.charAt(r)] >= 0)
                --required;
            while (required == 0) {
                if (r - l + 1 == p.length())
                    ans.add(l);
                if (++count[s.charAt(l++)] > 0)
                    ++required;
            }
        }

        return ans;
    }
}
