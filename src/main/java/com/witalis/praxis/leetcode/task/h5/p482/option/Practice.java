package com.witalis.praxis.leetcode.task.h5.p482.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * ID: 482
 * Name: License Key Formatting
 * URL: <a href="https://leetcode.com/problems/license-key-formatting/">License Key Formatting</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;
    private int key;

    public String process() {
        return licenseKeyFormatting(string, key);
    }

    public String licenseKeyFormatting(String s, int k) {
        if (s == null || s.length() == 0) return s;

        StringBuilder licenseKey = new StringBuilder();

        int keyIndex = 0;
        char[] keyGroup = new char[k];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;

            if (keyIndex == k) {
                licenseKey.append(keyGroup).append('-');
                keyIndex = 0;
            }
            keyGroup[keyIndex++] = Character.toUpperCase(s.charAt(i));
        }
        if (keyIndex > 0) licenseKey.append(Arrays.copyOfRange(keyGroup, 0, keyIndex));

        return licenseKey.reverse().toString();
    }
}
