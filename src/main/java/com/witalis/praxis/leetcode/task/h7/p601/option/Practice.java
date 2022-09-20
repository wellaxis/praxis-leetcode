package com.witalis.praxis.leetcode.task.h7.p601.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 601
 * Name: Human Traffic of Stadium
 * URL: <a href="https://leetcode.com/problems/human-traffic-of-stadium/">Human Traffic of Stadium</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return stadiumHumanTraffic();
    }

    public String stadiumHumanTraffic() {
        return
            """

            WITH sn AS (
                SELECT s.id,
                       s.visit_date,
                       CASE WHEN s.people >= 100 THEN s.people ELSE NULL END AS people
                FROM   stadium s
            )
            SELECT s.id AS "id",
                   TO_CHAR(s.visit_date, 'YYYY-MM-DD') AS "visit_date",
                   s.people AS "people"
            FROM (
                SELECT s.id,
                       s.visit_date,
                       s.people,
                       DECODE(s.people, NULL, 0, 1) AS coef,
                       LAG(people, 1) OVER (ORDER BY s.id) AS prev1,
                       LAG(people, 2) OVER (ORDER BY s.id) AS prev2,
                       LEAD(people, 1) OVER (ORDER BY s.id) AS next1,
                       LEAD(people, 2) OVER (ORDER BY s.id) AS next2
                FROM   sn s
            )s
            WHERE coef * (NVL(prev1 + prev2, 0) + NVL(next1 + next2, 0) + NVL(prev1 + next1, 0)) >= 1

            """;
    }
}
