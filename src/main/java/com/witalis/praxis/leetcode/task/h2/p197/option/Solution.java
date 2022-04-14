package com.witalis.praxis.leetcode.task.h2.p197.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 197
 * Name: Rising Temperature
 * URL: <a href="https://leetcode.com/problems/rising-temperature/">Rising Temperature</a>
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

            SELECT weather.id AS 'Id'
            FROM   weather
              JOIN weather w
            ON     DATEDIFF(weather.recordDate, w.recordDate) = 1
            AND    weather.Temperature > w.Temperature

            """;
    }
}
