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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<List<String>> paths;

    public String process() {
        return destCity(paths);
    }

    public String destCity(List<List<String>> paths) {
        if (paths == null) return "";

        Set<String> sources = new HashSet<>();
        Set<String> targets = new HashSet<>();

        for (List<String> path : paths) {
            sources.add(path.get(0));

            if (targets.contains(path.get(0))) {
                targets.remove(path.get(0));
            }

            if (!sources.contains(path.get(1))) {
                targets.add(path.get(1));
            }
        }

        return targets.iterator().next();
    }
}
