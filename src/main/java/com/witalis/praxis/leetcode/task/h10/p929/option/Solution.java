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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private String[] emails;

    public Integer process() {
        return numUniqueEmails(emails);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        int count = 0;
        for (String email : emails) {
            int atIndex = email.indexOf("@");
            int plusIndex = email.indexOf("+");
            String str1 = "";
            if (plusIndex >= 0) str1 = email.substring(0, plusIndex);
            else str1 = email.substring(0, atIndex);
            str1 = str1.replace(".", "") + email.substring(atIndex);
            if (set.add(str1)) count++;
        }

        return count;
    }
}
