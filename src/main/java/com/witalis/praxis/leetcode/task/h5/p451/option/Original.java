package com.witalis.praxis.leetcode.task.h5.p451.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ID: 451
 * Name: Sort Characters By Frequency
 * URL: <a href="https://leetcode.com/problems/sort-characters-by-frequency/">Sort Characters By Frequency</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return frequencySort(string);
    }

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder builder = new StringBuilder();
        s.chars()
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
            .forEach(e -> builder.append(String.valueOf((char) e.getKey().intValue()).repeat(e.getValue().intValue())));

        return builder.toString();
    }
}
