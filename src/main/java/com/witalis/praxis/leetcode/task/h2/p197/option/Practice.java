package com.witalis.praxis.leetcode.task.h2.p197.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 197
 * Name: Rising Temperature
 * URL: https://leetcode.com/problems/rising-temperature/
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

            SELECT w.id as id
            FROM   weather w,
                   weather wy
            WHERE  DATEDIFF(w.recordDate, wy.recordDate) = 1
            AND    wy.temperature < w.temperature

            """;
    }
}
