package com.witalis.praxis.leetcode.task.h13.p1211.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1211
 * Name: Queries Quality and Percentage
 * URL: <a href="https://leetcode.com/problems/queries-quality-and-percentage/">Queries Quality and Percentage</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return queriesQualityPercentage();
    }

    public String queriesQualityPercentage() {
        return
            """

            SELECT q.query_name,
                   ROUND(SUM(q.quality) / SUM(q.quantity), 2) AS quality,
                   ROUND(SUM(q.is_poor) / SUM(q.quantity) * 100, 2) AS poor_query_percentage
            FROM (
                SELECT q.query_name,
                       q.rating / q.position AS quality,
                       1 AS quantity,
                       CASE WHEN q.rating < 3 THEN 1 ELSE 0 END AS is_poor
                FROM   queries q
                WHERE  q.query_name IS NOT NULL
            ) q
            GROUP BY q.query_name

            """;
    }
}
