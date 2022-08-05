package com.witalis.praxis.leetcode.task.h2.p180.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 180
 * Name: Consecutive Numbers
 * URL: <a href="https://leetcode.com/problems/consecutive-numbers/">Consecutive Numbers</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return consecutiveNumbers();
    }

    public String consecutiveNumbers() {
        return
            """

            SELECT DISTINCT l.num AS "ConsecutiveNums"
            FROM   (SELECT l.id,
                           l.num,
                           LAG(l.num) OVER(ORDER BY l.id) AS previous,
                           LEAD(l.num) OVER(ORDER BY l.id) AS next
                    FROM   logs l
                    ) l
            WHERE   l.num = l.previous
            AND     l.num = l.next

            """;
    }
}
