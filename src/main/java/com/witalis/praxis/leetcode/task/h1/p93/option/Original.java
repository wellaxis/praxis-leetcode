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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private String string;

    public List<String> process() {
        return restoreIpAddresses(string);
    }

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.isEmpty()) return Collections.emptyList();

        List<String> addresses = new ArrayList<>();

        var correctness = s.chars().mapToObj(c -> (char) c).allMatch(Character::isDigit);
        if (!correctness) return addresses;

        recursiveRestore(addresses, s, 0, "");
        return addresses;
    }

    private void recursiveRestore(List<String> addresses, String s, int index, String address) {
        if (index == s.length() && address.split("\\.").length == 4) {
            addresses.add(address.substring(0, address.length() - 1));
        } else {
            String mask = address;
            for (int i = index; i < s.length(); i++) {
                char c = s.charAt(i);

                mask = mask + c;

                if (isValid(mask)) {
                    recursiveRestore(addresses, s, i + 1, mask + '.');
                } else {
                    break;
                }
            }
        }
    }

    private boolean isValid(String address) {
        var octets = address.split("\\.");
        if (octets.length > 4) return false;

        String octet = octets[octets.length - 1];

        if (octet.startsWith("0") && octet.length() > 1) return false;
        return Integer.parseInt(octet) <= 255;
    }
}
