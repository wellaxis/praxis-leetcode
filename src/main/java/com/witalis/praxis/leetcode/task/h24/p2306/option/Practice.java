package com.witalis.praxis.leetcode.task.h24.p2306.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2306
 * Name: Naming a Company
 * URL: <a href="https://leetcode.com/problems/naming-a-company/">Naming a Company</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] ideas;

    public Long process() {
        return distinctNames(ideas);
    }

    public long distinctNames(String[] ideas) {
        return 0;
    }
}
