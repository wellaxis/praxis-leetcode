package com.witalis.praxis.leetcode.task.h8.p709.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 709
 * Name: To Lower Case
 * URL: <a href="https://leetcode.com/problems/to-lower-case/">To Lower Case</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public String process() {
        return toLowerCase(string);
    }

    public String toLowerCase(String s) {
        return s.chars()
            .mapToObj(i -> (char) i)
            .map(Character::toLowerCase)
            .map(Object::toString)
            .reduce("", String::concat);
    }
}
