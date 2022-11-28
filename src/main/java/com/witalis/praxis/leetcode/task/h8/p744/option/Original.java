package com.witalis.praxis.leetcode.task.h8.p744.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * ID: 744
 * Name: Find Smallest Letter Greater Than Target
 * URL: <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/">Find Smallest Letter Greater Than Target</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private char[] letters;
    private char target;

    public Character process() {
        return nextGreatestLetter(letters, target);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) return 0;

        return IntStream.range(0, letters.length)
            .mapToObj(i -> letters[i])
            .sorted()
            .distinct()
            .filter(character -> character > target)
            .findFirst()
            .orElse(letters[0]);
    }
}
