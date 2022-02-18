package com.witalis.praxis.leetcode.task.h2.p182.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 182
 * Name: Duplicate Emails
 * URL: https://leetcode.com/problems/duplicate-emails/
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

            SELECT pd.email AS "Email"
            FROM   (
                SELECT p.email, COUNT(p.id) AS qty
                FROM   person p
                GROUP BY p.email
            ) pd
            WHERE  pd.qty > 1
            ORDER BY pd.qty DESC

            """;
    }
}
