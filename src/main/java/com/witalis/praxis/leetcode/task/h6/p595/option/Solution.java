package com.witalis.praxis.leetcode.task.h6.p595.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 595
 * Name: Big Countries
 * URL: <a href="https://leetcode.com/problems/big-countries/">Big Countries</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return bigCountries();
    }

    public String bigCountries() {
        return
            """
            SELECT name,
                   population,
                   area
            FROM   world
            WHERE  area >= 3000000
            UNION
            SELECT name,
                   population,
                   area
            FROM   world
            WHERE  population >= 25000000

            """;
    }
}
