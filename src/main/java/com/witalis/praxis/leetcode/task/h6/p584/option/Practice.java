package com.witalis.praxis.leetcode.task.h6.p584.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 584
 * Name: Find Customer Referee
 * URL: <a href="https://leetcode.com/problems/find-customer-referee/">Find Customer Referee</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return findCustomerReferee();
    }

    public String findCustomerReferee() {
        return
            """

            SELECT c.name
            FROM   customer c
            WHERE  NVL(c.referee_id, 0) NOT IN (2)

            """;
    }
}
