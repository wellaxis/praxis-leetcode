package com.witalis.praxis.leetcode.task.h2.p175.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 175
 * Name: Combine Two Tables
 * URL: <a href="https://leetcode.com/problems/combine-two-tables/">Combine Two Tables</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return employeesEarning();
    }

    public String employeesEarning() {
        return
            """

            SELECT p.firstname,
                   p.lastname,
                   (SELECT a.city
                    FROM   address a
                    WHERE  a.personid = p.personid
                   ) AS city,
                   (SELECT a.state
                    FROM   address a
                    WHERE  a.personid = p.personid
                   ) AS state
            FROM   person p

            """;
    }
}
