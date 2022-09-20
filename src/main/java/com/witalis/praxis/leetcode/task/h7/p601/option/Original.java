package com.witalis.praxis.leetcode.task.h7.p601.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 601
 * Name: Human Traffic of Stadium
 * URL: <a href="https://leetcode.com/problems/human-traffic-of-stadium/">Human Traffic of Stadium</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

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
                       s.visit_date,
                       s.people,
                       (SELECT 1
                        FROM   stadium ps
                        WHERE  ps.id = s.id - 1
                        AND    ps.people >= 100
                       ) prev1,
                       (SELECT 1
                        FROM   stadium ps
                        WHERE  ps.id = s.id - 2
                        AND    ps.people >= 100
                       ) prev2,
                       (SELECT 1
                        FROM   stadium ns
                        WHERE  ns.id = s.id + 1
                        AND    ns.people >= 100
                       ) next1,
                       (SELECT 1
                        FROM   stadium ns
                        WHERE  ns.id = s.id + 2
                        AND    ns.people >= 100
                       ) next2
                FROM   stadium s
                WHERE  s.people >= 100
            ) s
            WHERE NVL(prev1 + prev2, 0) + NVL(next1 + next2, 0) + NVL(prev1 + next1, 0) >= 1
            ORDER BY s.visit_date ASC

            """;
    }
}
