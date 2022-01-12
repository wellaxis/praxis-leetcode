package com.witalis.praxis.leetcode.task.h2.p175.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 175
 * Name: Combine Two Tables
 * URL: https://leetcode.com/problems/combine-two-tables/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return employeesEarning();
    }

    public String employeesEarning() {
        return
            """

            SELECT p.firstname,
                   p.lastname,
                   a.city,
                   a.state
            FROM   person p
              LEFT JOIN address a
            ON a.personid = p.personid

            """;
    }
}
