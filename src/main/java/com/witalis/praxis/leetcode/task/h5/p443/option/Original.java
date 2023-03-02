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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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
        int fast = 0;
        char previous = chars[0];
        while (fast < n) {
            int count = 0;
            while (fast < n && previous == chars[fast]) {
                fast++;
                count++;
            }
            chars[slow++] = previous;
            if (count > 1) {
                if (count < 10) {
                    chars[slow++] = (char) ('0' + count);
                } else {
                    for (char digit : String.valueOf(count).toCharArray()) {
                        chars[slow++] = digit;
                    }
                }
            }
            if (fast < n) previous = chars[fast];
        }

        return slow;
    }
}
