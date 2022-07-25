package com.witalis.praxis.leetcode.task.h6.p500.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 500
 * Name: Keyboard Row
 * URL: <a href="https://leetcode.com/problems/keyboard-row/">Keyboard Row</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] words;

    public String[] process() {
        return findWords(words);
    }

    public String[] findWords(String[] words) {
        String first = "qwertyuiopQWERTYUIOP";
        String second = "asdfghjklASDFGHJKL";
        String third = "zxcvbnmZXCVBNM";

        List<String> list = new ArrayList<>();
        for (String str : words) {
            String tmp;
            if (first.indexOf(str.charAt(0)) != -1) {
                tmp = first;
            } else if (second.indexOf(str.charAt(0)) != -1){
                tmp =second;
            } else if (third.indexOf(str.charAt(0)) != -1) {
                tmp = third;
            } else {
                continue;
            }

            boolean allFound = true;
            for (int i =1; i < str.length(); i++) {
                if (tmp.indexOf(str.charAt(i)) == -1) {
                    allFound = false;
                    break;
                }
            }
            if (allFound) {
                list.add(str);
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
