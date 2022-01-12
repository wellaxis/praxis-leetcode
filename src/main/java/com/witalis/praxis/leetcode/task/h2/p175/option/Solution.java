package com.witalis.praxis.leetcode.task.h2.p175.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 175
 * Name: Combine Two Tables
 * URL: https://leetcode.com/problems/combine-two-tables/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return employeesEarning();
    }

    public String employeesEarning() {
        return
            """

            SELECT FirstName,
                   LastName,
                   City,
                   State
            FROM   Person LEFT JOIN Address
            ON     Person.PersonId = Address.PersonId

            """;
    }
}
