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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private char[] chars;

    public Map<Integer, String> process() {
        final int size = compress(chars);
        final char[] compression = new char[size];
        System.arraycopy(chars, 0, compression, 0, size);

        return Map.of(size, String.valueOf(compression));
    }

    public int compress(char[] chars) {
        if (chars == null) return 0;

        final int n = chars.length;
        if (n == 1) return 1;

        int slow = 0;
        int fast = 1;
        while (fast <= n) {
            int count = 1;
            while (fast < n && chars[fast - 1] == chars[fast]) {
                fast++;
                count++;
            }
            chars[slow++] = chars[fast - 1];
            if (count > 1) {
                if (count < 10) {
                    chars[slow++] = (char) ('0' + count);
                } else {
                    final int length = (int) (Math.log10(count) + 1);
                    slow += length;
                    for (int i = 0; i < length; i++) {
                        chars[slow - i - 1] = (char) ('0' + count % 10);
                        count /= 10;
                    }
                }
            }
            fast++;
        }

        return slow;
    }
}
