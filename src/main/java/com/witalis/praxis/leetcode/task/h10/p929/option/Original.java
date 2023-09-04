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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
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

    private String resolveEmail(String email) {
        if (email == null || email.isEmpty()) return "";

        int separator = email.indexOf("@");
        String localName = email.substring(0, separator);
        String domainName = email.substring(separator + 1);

        localName = localName.replaceAll("\\.", "");
        if (localName.contains("+"))
            localName = localName.substring(0, localName.indexOf("+"));

        return localName + "@" + domainName;
    }
}
