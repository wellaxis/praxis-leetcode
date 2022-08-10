package com.witalis.praxis.leetcode.task.h6.p584.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 584
 * Name: Find Customer Referee
 * URL: <a href="https://leetcode.com/problems/find-customer-referee/">Find Customer Referee</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return findCustomerReferee();
    }

    public String findCustomerReferee() {
        return
            """

            SELECT name
            FROM   customer
            WHERE  referee_id != 2 OR referee_id IS NULL

            """;
    }
}
