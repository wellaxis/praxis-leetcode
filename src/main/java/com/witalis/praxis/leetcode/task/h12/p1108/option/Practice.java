package com.witalis.praxis.leetcode.task.h12.p1108.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1108
 * Name: Defanging an IP Address
 * URL: <a href="https://leetcode.com/problems/defanging-an-ip-address/">Defanging an IP Address</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String address;

    public String process() {
        return defangIPaddr(address);
    }

    public String defangIPaddr(String address) {
        if (address == null || address.isEmpty()) return "";

        final StringBuilder builder = new StringBuilder();
        final char[] letters = address.toCharArray();
        for (char letter : letters)
            if (letter == '.')
                builder.append("[.]");
            else
                builder.append(letter);

        return builder.toString();
    }
}
