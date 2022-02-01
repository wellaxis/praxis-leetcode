package com.witalis.praxis.leetcode.task.h2.p197.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 197
 * Name: Rising Temperature
 * URL: https://leetcode.com/problems/rising-temperature/
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

            SELECT w.id
            FROM   weather w,
                   weather wy
            WHERE  wy.recorddate = w.recorddate - 1
            AND    wy.temperature < w.temperature

            """;
    }
}
