package com.witalis.praxis.leetcode.task.h15.p1436.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ID: 1436
 * Name: Destination City
 * URL: <a href="https://leetcode.com/problems/destination-city/">Destination City</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<List<String>> paths;

    public String process() {
        return destCity(paths);
    }

    public String destCity(List<List<String>> paths) {
        Set<String> hasOutgoing = new HashSet<>();
        for (int i = 0; i < paths.size(); i++) {
            hasOutgoing.add(paths.get(i).get(0));
        }

        for (int i = 0; i < paths.size(); i++) {
            String candidate = paths.get(i).get(1);
            if (!hasOutgoing.contains(candidate)) {
                return candidate;
            }
        }

        return "";
    }
}
