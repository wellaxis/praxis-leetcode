package com.witalis.praxis.leetcode.task.h8.p709.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 709
 * Name: To Lower Case
 * URL: <a href="https://leetcode.com/problems/to-lower-case/">To Lower Case</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public String process() {
        return toLowerCase(string);
    }

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
