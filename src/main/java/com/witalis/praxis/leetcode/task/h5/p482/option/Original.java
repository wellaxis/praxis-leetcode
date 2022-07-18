package com.witalis.praxis.leetcode.task.h5.p482.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 482
 * Name: License Key Formatting
 * URL: <a href="https://leetcode.com/problems/license-key-formatting/">License Key Formatting</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;
    private int key;

    public String process() {
        return licenseKeyFormatting(string, key);
    }

    public String licenseKeyFormatting(String s, int k) {
        if (s == null || s.length() == 0) return s;

        StringBuilder licenseKey = new StringBuilder();
        StringBuilder keyGroup = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;

            if (keyGroup.length() == k) {
                licenseKey.append(keyGroup).append('-');
                keyGroup.setLength(0);
            }
            keyGroup.append(Character.toUpperCase(s.charAt(i)));
        }
        if (keyGroup.length() > 0) licenseKey.append(keyGroup);

        return licenseKey.reverse().toString();
    }
}
