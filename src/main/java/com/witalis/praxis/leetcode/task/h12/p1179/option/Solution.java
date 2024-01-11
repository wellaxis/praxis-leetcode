package com.witalis.praxis.leetcode.task.h12.p1179.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1179
 * Name: Reformat Department Table
 * URL: <a href="https://leetcode.com/problems/reformat-department-table/">Reformat Department Table</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return reformatDepartmentTable();
    }

    public String reformatDepartmentTable() {
        return
            """

            SELECT *
            FROM   department
            PIVOT (
                SUM(revenue) FOR month IN (
                    'Jan' AS "Jan_Revenue",
                    'Feb' AS "Feb_Revenue",
                    'Mar' AS "Mar_Revenue",
                    'Apr' AS "Apr_Revenue",
                    'May' AS "May_Revenue",
                    'Jun' AS "Jun_Revenue",
                    'Jul' AS "Jul_Revenue",
                    'Aug' AS "Aug_Revenue",
                    'Sep' AS "Sep_Revenue",
                    'Oct' AS "Oct_Revenue",
                    'Nov' AS "Nov_Revenue",
                    'Dec' AS "Dec_Revenue"
                )
            )

            """;
    }
}
