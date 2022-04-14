package com.witalis.praxis.leetcode.task.h2.p196.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 196
 * Name: Delete Duplicate Emails
 * URL: <a href="https://leetcode.com/problems/delete-duplicate-emails/">Delete Duplicate Emails</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return duplicateEmails();
    }

    public String duplicateEmails() {
        return
            """

            DELETE
            FROM   person p
            WHERE  p.id NOT IN (
                SELECT MIN(up.id)
                FROM   person up
                GROUP BY up.email
            )

            """;
    }
}
