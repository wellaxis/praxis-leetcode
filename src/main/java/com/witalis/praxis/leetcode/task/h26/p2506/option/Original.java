package com.witalis.praxis.leetcode.task.h26.p2506.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 2506
 * Name: Count Pairs Of Similar Strings
 * URL: <a href="https://leetcode.com/problems/count-pairs-of-similar-strings/">Count Pairs Of Similar Strings</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;

    public Integer process() {
        return similarPairs(words);
    }

    public int similarPairs(String[] words) {
        if (words == null) return 0;

        final int n = words.length;

        int pairs = 0;
        for (int i = 0; i < n; i++) {
            int[] word1Frequency = charsFrequency(words[i]);

            for (int j = i + 1; j < n; j++) {
                int[] word2Frequency = charsFrequency(words[j]);

                boolean similar = true;
                for (int k = 0; k < 26; k++) {
                    int f1 = word1Frequency[k];
                    int f2 = word2Frequency[k];

                    if ((f1 != 0 && f2 == 0 ) || (f1 == 0 && f2 != 0)) {
                        similar = false;
                        break;
                    }
                }

                if (similar) pairs++;
            }
        }

        return pairs;
    }

    private int[] charsFrequency(String word) {
        final int[] frequency = new int[26];
        final char[] letters = word.toCharArray();

        for (char letter : letters) {
            frequency[letter - 'a']++;
        }

        return frequency;
    }
}
