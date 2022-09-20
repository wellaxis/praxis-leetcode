package com.witalis.praxis.leetcode.task.h7.p601.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 601
 * Name: Human Traffic of Stadium
 * URL: <a href="https://leetcode.com/problems/human-traffic-of-stadium/">Human Traffic of Stadium</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return stadiumHumanTraffic();
    }

    public String stadiumHumanTraffic() {
        return
            """

            SELECT s.id AS "id",
                   TO_CHAR(s.visit_date, 'YYYY-MM-DD') AS "visit_date",
                   s.people AS "people"
            FROM (
                SELECT s.id,
                       LEAD(s.id) OVER(ORDER BY s.id) id2,
                       LEAD(s.id, 2) OVER(ORDER BY s.id) id3,
                       LAG(s.id) OVER(ORDER BY s.id) id4,
                       LAG(s.id, 2) OVER(ORDER BY s.id) id5,
                       s.visit_date,
                       s.people
                FROM   stadium s
                WHERE  s.people >= 100
            ) s
            WHERE  s.id2 - s.id = s.id3 - s.id2
            OR     s.id4 - s.id5 = s.id - s.id4
            OR     s.id2 - s.id = s.id - s.id4

            """;
    }
}
