package com.witalis.praxis.leetcode.task.h1.p93.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ID: 93
 * Name: Restore IP Addresses
 * URL: https://leetcode.com/problems/restore-ip-addresses/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String string;

    public List<String> process() {
        return restoreIpAddresses(string);
    }

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) return Collections.emptyList();

        List<String> addresses = new ArrayList<>();

        var correctness = s.chars().mapToObj(c -> (char) c).allMatch(Character::isDigit);
        if (correctness) {
            recursiveRestore(addresses, s, 0, new String[] {"", "", "", ""}, 0);
        }
        return addresses;
    }

    private void recursiveRestore(List<String> addresses, String s, int position, String[] address, int index) {
        if (index == 4) {
            if (position == s.length()) {
                addresses.add(String.join(".", address));
            }
        } else {
            if (position >= s.length()) return;
            int length = s.charAt(position) == '0' ? 1 : 3;
            for (int i = 1; i <= length && position + i <= s.length(); i++) {
                String octet = s.substring(position, position + i);

                if (Integer.parseInt(octet) > 255 || (octet.startsWith("0") && octet.length() > 1)) break;

                address[index] = octet;
                recursiveRestore(addresses, s, position + i, address, index + 1);
            }
        }
    }
}
