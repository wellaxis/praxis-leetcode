package com.witalis.praxis.leetcode.task.h1.p49.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * ID: 49
 * Name: Group Anagrams
 * URL: https://leetcode.com/problems/powx-n/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] strings;

    public List<List<String>> process() {
        return groupAnagrams(strings);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();

        return new ArrayList<>(
            Arrays.stream(strs)
                .collect(
                    toMap(
                        s -> {
                            var chars = s.toCharArray();
                            Arrays.sort(chars);
                            return String.valueOf(chars);
                        },
                        s -> new ArrayList<>(List.of(s)),
                        (l1, l2) -> {
                            l1.addAll(l2);
                            return l1;
                        }
                    )
                )
                .values()
        );
    }
}
