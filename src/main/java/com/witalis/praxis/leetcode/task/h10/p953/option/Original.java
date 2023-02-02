package com.witalis.praxis.leetcode.task.h10.p953.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * ID: 953
 * Name: Verifying an Alien Dictionary
 * URL: <a href="https://leetcode.com/problems/verifying-an-alien-dictionary/">Verifying an Alien Dictionary</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String[] words;
    private String order;

    public Boolean process() {
        return isAlienSorted(words, order);
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || order == null) return false;

        int n = words.length;
        Map<Character, Integer> positions = new HashMap<>();
        char[] alphabet = order.toCharArray();
        for (int i = 0; i < alphabet.length; i++) {
            positions.put(alphabet[i], i);
        }

        String[] clone = words.clone();
        Comparator<String> alienComparator = (w1, w2) -> {
            if (w1.equals(w2)) return 0;

            int len = Math.min(w1.length(), w2.length());
            int pos = 0;
            while (pos < len) {
                int curr = positions.get(w1.charAt(pos));
                int prev = positions.get(w2.charAt(pos));

                if (curr < prev) return -1;
                if (curr > prev) break;
                pos++;
            }
            if (pos == len && w1.length() < w2.length()) return -1;
            return 1;
        };
        Arrays.sort(clone, alienComparator);

        for (int i = 0; i < n; i++) {
            if (!words[i].equals(clone[i])) return false;
        }

        return true;
    }
}
