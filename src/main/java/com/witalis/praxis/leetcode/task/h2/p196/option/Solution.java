package com.witalis.praxis.leetcode.task.h2.p196.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 196
 * Name: Delete Duplicate Emails
 * URL: https://leetcode.com/problems/delete-duplicate-emails/
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

            DELETE p1
            FROM   person p1,
                   person p2
            WHERE  p1.email = p2.email
            AND    p1.id > p2.id

            """;
    }
}
