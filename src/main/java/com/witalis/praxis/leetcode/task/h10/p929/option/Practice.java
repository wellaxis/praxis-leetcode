package com.witalis.praxis.leetcode.task.h10.p929.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * ID: 929
 * Name: Unique Email Addresses
 * URL: <a href="https://leetcode.com/problems/unique-email-addresses/">Unique Email Addresses</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private String[] emails;

    public Integer process() {
        return numUniqueEmails(emails);
    }

    public int numUniqueEmails(String[] emails) {
        if (emails == null) return 0;

        final Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails)
            uniqueEmails.add(resolveEmail(email));

        return uniqueEmails.size();
    }

    private static String resolveEmail(String email) {
        if (email == null || email.isEmpty()) return "";

        final int separator = email.indexOf("@");

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < separator; i++) {
            if (email.charAt(i) == '+') break;
            if (email.charAt(i) == '.') continue;

            builder.append(email.charAt(i));
        }

        return builder + email.substring(separator);
    }
}
