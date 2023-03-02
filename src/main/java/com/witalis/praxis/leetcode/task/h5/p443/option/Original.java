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
        return Map.of(compress(chars), String.valueOf(chars));
    }

    public int compress(char[] chars) {
        return 0;
    }
}
