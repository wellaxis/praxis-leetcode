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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<List<String>> paths;

    public String process() {
        return destCity(paths);
    }

    public String destCity(List<List<String>> paths) {
        if (paths == null) return "";

        Set<String> cities = new HashSet<>();

        for (List<String> path : paths)
            cities.add(path.get(0));

        for (List<String> path : paths)
            if (!cities.contains(path.get(1)))
                return path.get(1);

        return "";
    }
}
