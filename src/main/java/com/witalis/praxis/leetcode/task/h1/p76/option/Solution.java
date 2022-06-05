package com.witalis.praxis.leetcode.task.h1.p76.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * ID: 76
 * Name: Minimum Window Substring
 * URL: <a href="https://leetcode.com/problems/minimum-window-substring/">Minimum Window Substring</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String source;
    private String target;

    public String process() {
        return minWindow(source, target);
    }

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        // dictionary which keeps a count of all the unique characters in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // number of unique characters in t, which need to be present in the desired window
        int required = dictT.size();

        // left and right pointer
        int l = 0;
        int r = 0;

        // formed is used to keep track of how many unique characters in t are present in the current window
        int formed = 0;

        // dictionary which keeps a count of all the unique characters in the current window.
        Map<Character, Integer> windowCounts = new HashMap<>();

        // answer list of the form (window length, left, right)
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            // add one character from the right to the window
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            // if the frequency of the current character added equals to the desired count in t then increment the formed count by 1
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // try and contract the window till the point where it ceases to be 'desirable'
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // save the smallest window until now.
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // the character at the position pointed by the `left` pointer is no longer a part of the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }

                // move the left pointer ahead, this would help to look for a new window
                l++;
            }

            // keep expanding the window once we are done contracting
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
