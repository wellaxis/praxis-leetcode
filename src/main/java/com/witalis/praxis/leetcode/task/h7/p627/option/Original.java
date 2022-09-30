package com.witalis.praxis.leetcode.task.h7.p627.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 627
 * Name: Swap Salary
 * URL: <a href="https://leetcode.com/problems/swap-salary/">Swap Salary</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return swapSalary();
    }

    public String swapSalary() {
        return
            """

            UPDATE salary s
            SET    s.sex = CASE WHEN s.sex = 'f' THEN 'm' ELSE 'f' END

            """;
    }
}
