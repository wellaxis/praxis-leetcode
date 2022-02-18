package com.witalis.praxis.leetcode.task.h2.p182.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 182
 * Name: Duplicate Emails
 * URL: https://leetcode.com/problems/duplicate-emails/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return duplicateEmails();
    }

    public String duplicateEmails() {
        return
            """

            SELECT p.email AS "Email"
            FROM   person p
            GROUP BY p.email HAVING COUNT(p.id) > 1
            ORDER BY COUNT(p.email) DESC

            """;
    }
}
