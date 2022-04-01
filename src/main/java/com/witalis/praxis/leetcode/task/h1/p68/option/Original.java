package com.witalis.praxis.leetcode.task.h1.p68.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 68
 * Name: Text Justification
 * URL: https://leetcode.com/problems/text-justification/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;
    private int maxWidth;

    public List<String> process() {
        return fullJustify(words, maxWidth);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null || words.length == 0 || maxWidth <= 0) return Collections.emptyList();

        List<String> text = new ArrayList<>();
        List<String> rows = new ArrayList<>();

        int length = 0;
        for (String word : words) {
            if (word.length() > maxWidth) return Collections.emptyList();

            int curWidth = length + rows.size() + word.length();
            if (curWidth > maxWidth) {
                // new line
                StringBuilder line = new StringBuilder();
                int extras = maxWidth - (length + rows.size() - 1);
                if (rows.size() == 1) {
                    line.append(rows.get(0)).append(" ".repeat(extras));
                } else {
                    for (int row = 0; row < rows.size(); row++) {
                        if (row > 0) line.append(" ");
                        line.append(rows.get(row));
                        if (extras > 0) {
                            int extra = Math.ceilDivExact(extras, (rows.size() - 1 - row));
                            line.append(" ".repeat(extra));
                            extras -= extra;
                        }
                    }
                }
                text.add(line.toString());
                rows.clear();
                length = 0;
            }
            // add word
            rows.add(word);
            length += word.length();
        }

        // last line
        String line = String.join(" ", rows);
        text.add(line.concat(" ".repeat(maxWidth - line.length())));

        return text;
    }
}
