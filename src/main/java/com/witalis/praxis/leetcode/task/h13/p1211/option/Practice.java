package com.witalis.praxis.leetcode.task.h13.p1211.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1211
 * Name: Queries Quality and Percentage
 * URL: <a href="https://leetcode.com/problems/queries-quality-and-percentage/">Queries Quality and Percentage</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return queriesQualityPercentage();
    }

    public String queriesQualityPercentage() {
        return
            """

            SELECT q.query_name,
                   ROUND(AVG(q.rating / q.position), 2) AS quality,
                   ROUND(AVG(CASE WHEN q.rating < 3 THEN 1 ELSE 0 END) * 100, 2) AS poor_query_percentage
            FROM   queries q
            WHERE  q.query_name IS NOT NULL
            GROUP BY q.query_name

            """;
    }
}
