package com.witalis.praxis.leetcode.task.h4.p318.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;

/**
 * ID: 318
 * Name: Maximum Product of Word Lengths
 * URL: <a href="https://leetcode.com/problems/maximum-product-of-word-lengths/">Maximum Product of Word Lengths</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;

    public Integer process() {
        return maxProduct(words);
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;

        int product = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String next = words[j];
                if (checkSharing(word, next)) {
                    product = Math.max(product, word.length() * next.length());
                }
            }
        }

        return product;
    }

    private static boolean checkSharing(String word1, String word2) {
        var chars1 = word1.chars().mapToObj(i -> (char) i).toList();
        var chars2 = word2.chars().mapToObj(i -> (char) i).toList();

        return Collections.disjoint(chars1, chars2);
    }
}
