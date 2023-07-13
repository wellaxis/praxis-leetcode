package com.witalis.praxis.leetcode.task.h9.p824.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

/**
 * ID: 824
 * Name: Goat Latin
 * URL: <a href="https://leetcode.com/problems/goat-latin/">Goat Latin</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String sentence;

    public String process() {
        return toGoatLatin(sentence);
    }

    public static final Set<Character> VOWELS = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
    public static final String SUFFIX = "ma";
    public static final String ANNEX = "a";
    public static final String SPACE = " ";

    public String toGoatLatin(String sentence) {
        if (sentence == null || sentence.isEmpty()) return sentence;

        final StringBuilder builder = new StringBuilder();
        final String[] words = sentence.split(SPACE);
        int counter = 0;
        for (String word : words) {
            char title = word.charAt(0);
            if (VOWELS.contains(title)) {
                builder.append(word);
            } else {
                builder.append(word.substring(1)).append(title);
            }
            builder.append(SUFFIX);
            builder.append(ANNEX.repeat(++counter));
            builder.append(SPACE);
        }

        return builder.substring(0, builder.length() - 1);
    }
}
