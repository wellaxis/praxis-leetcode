package com.witalis.praxis.leetcode.task.h1.p68.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 68
 * Name: Text Justification
 * URL: <a href="https://leetcode.com/problems/text-justification/">Text Justification</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] words;
    private int maxWidth;

    public List<String> process() {
        return fullJustify(words, maxWidth);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0 || maxWidth <= 0) return Collections.emptyList();

        List<String> text = new ArrayList<>();
        Deque<Integer> spaces = new ArrayDeque<>();
        StringBuilder line = new StringBuilder();

        for (String word: words) {
            if (word.length() > maxWidth) return Collections.emptyList();

            int curWidth = line.length() + word.length() + ((line.isEmpty()) ? 0 : 1);
            if (curWidth > maxWidth) {
                // new line
                int extras = maxWidth - line.length();
                while (extras > 0 && !spaces.isEmpty()) {
                    int extra = extras / spaces.size();
                    int space = spaces.pollLast();
                    line.insert(space, " ".repeat(extra));
                    extras -= extra;
                }
                if (extras > 0) line.append(" ".repeat(extras));

                text.add(line.toString());
                line = new StringBuilder();
                spaces.clear();
            }
            // add word
            if (!line.isEmpty()) {
                line.append(" ");
                spaces.add(line.length());
            }
            line.append(word);
        }

        // last line
        if (!line.isEmpty()) {
            line.append(" ".repeat(maxWidth - line.length()));
            text.add(line.toString());
        }

        return text;
    }
}
