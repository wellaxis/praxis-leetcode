package com.witalis.praxis.leetcode.task.h10.p953.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 953
 * Name: Verifying an Alien Dictionary
 * URL: <a href="https://leetcode.com/problems/verifying-an-alien-dictionary/">Verifying an Alien Dictionary</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;
    private String order;

    public Boolean process() {
        return isAlienSorted(words, order);
    }

    public boolean isAlienSorted(String[] words, String order) {
        return false;
    }
}
