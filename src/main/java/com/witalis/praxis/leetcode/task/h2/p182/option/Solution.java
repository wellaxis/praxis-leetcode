package com.witalis.praxis.leetcode.task.h2.p182.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 182
 * Name: Duplicate Emails
 * URL: <a href="https://leetcode.com/problems/duplicate-emails/">Duplicate Emails</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return duplicateEmails();
    }

    public String duplicateEmails() {
        return
            """

            SELECT DISTINCT p1.email AS "Email"
            FROM   person p1,
                   person p2
            WHERE  p1.email = p2.email
            AND    p1.id != p2.id

            """;
    }
}
