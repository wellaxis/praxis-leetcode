package com.witalis.praxis.leetcode.task.h12.p1179.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1179
 * Name: Reformat Department Table
 * URL: <a href="https://leetcode.com/problems/reformat-department-table/">Reformat Department Table</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return reformatDepartmentTable();
    }

    public String reformatDepartmentTable() {
        return
            """

            SELECT d.id,
                   SUM(DECODE(d.month, 'Jan', d.revenue, NULL)) AS Jan_Revenue,
                   SUM(DECODE(d.month, 'Feb', d.revenue, NULL)) AS Feb_Revenue,
                   SUM(DECODE(d.month, 'Mar', d.revenue, NULL)) AS Mar_Revenue,
                   SUM(DECODE(d.month, 'Apr', d.revenue, NULL)) AS Apr_Revenue,
                   SUM(DECODE(d.month, 'May', d.revenue, NULL)) AS May_Revenue,
                   SUM(DECODE(d.month, 'Jun', d.revenue, NULL)) AS Jun_Revenue,
                   SUM(DECODE(d.month, 'Jul', d.revenue, NULL)) AS Jul_Revenue,
                   SUM(DECODE(d.month, 'Aug', d.revenue, NULL)) AS Aug_Revenue,
                   SUM(DECODE(d.month, 'Sep', d.revenue, NULL)) AS Sep_Revenue,
                   SUM(DECODE(d.month, 'Oct', d.revenue, NULL)) AS Oct_Revenue,
                   SUM(DECODE(d.month, 'Nov', d.revenue, NULL)) AS Nov_Revenue,
                   SUM(DECODE(d.month, 'Dec', d.revenue, NULL)) AS Dec_Revenue
            FROM   department d
            GROUP BY d.id
            ORDER BY d.id

            """;
    }
}
