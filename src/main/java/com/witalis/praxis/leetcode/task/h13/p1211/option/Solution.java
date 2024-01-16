package com.witalis.praxis.leetcode.task.h13.p1211.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1211
 * Name: Queries Quality and Percentage
 * URL: <a href="https://leetcode.com/problems/queries-quality-and-percentage/">Queries Quality and Percentage</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return queriesQualityPercentage();
    }

    public String queriesQualityPercentage() {
        return
            """

            WITH totals AS (
                SELECT t.query_name,
                       COUNT(*) AS quantity
                FROM   queries t
                GROUP BY t.query_name
            )
            SELECT q.query_name,
                   ROUND(SUM(q.rating / q.position) / t.quantity, 2) AS quality,
                   ROUND(SUM((CASE WHEN q.rating < 3 THEN 1 ELSE 0 END)) * 100 / t.quantity, 2) AS poor_query_percentage
            FROM   queries q
            JOIN   totals t ON q.query_name = t.query_name
            GROUP BY q.query_name, t.quantity

            """;
    }
}
