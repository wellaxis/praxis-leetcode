package com.witalis.praxis.leetcode.task.h5.p443.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * ID: 443
 * Name: String Compression
 * URL: <a href="https://leetcode.com/problems/string-compression/">String Compression</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private char[] chars;

    public Map<Integer, String> process() {
        final int size = compress(chars);
        final char[] compression = new char[size];
        System.arraycopy(chars, 0, compression, 0, size);

        return Map.of(size, String.valueOf(compression));
    }

    public int compress(char[] chars) {
        int ans = 0;

        for (int i = 0; i < chars.length;) {
            final char letter = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == letter) {
                ++count;
                ++i;
            }
            chars[ans++] = letter;
            if (count > 1)
                for (final char c : String.valueOf(count).toCharArray())
                    chars[ans++] = c;
        }

        return ans;
    }
}
