package com.witalis.praxis.leetcode.task.h4.p318.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 318
 * Name: Maximum Product of Word Lengths
 * URL: <a href="https://leetcode.com/problems/maximum-product-of-word-lengths/">Maximum Product of Word Lengths</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] words;

    public Integer process() {
        return maxProduct(words);
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;

        int product = 0;

        int[] sums = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            sums[i] = bitRepresentation(words[i]);
        }

        for (int i = 0; i < sums.length; i++) {
            int sum = sums[i];
            for (int j = i + 1; j < sums.length; j++) {
                int next = sums[j];
                if ((sum & next) == 0) {
                    product = Math.max(product, words[i].length() * words[j].length());
                }
            }
        }

        return product;
    }

    private static int bitRepresentation(String word) {
        int sum = 0;
        boolean[] seen = new boolean[26];
        char[] letters = word.toCharArray();
        for (char letter : letters) {
            if (!seen[letter - 'a']) {
                sum += Math.pow(2, (double) letter - 'a');
                seen[letter - 'a'] = true;
            }
        }

        return sum;
    }
}
