package com.witalis.praxis.leetcode.task.h2.p180.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 180
 * Name: Consecutive Numbers
 * URL: <a href="https://leetcode.com/problems/consecutive-numbers/">Consecutive Numbers</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return consecutiveNumbers();
    }

    public String consecutiveNumbers() {
        return
            """

            SELECT DISTINCT l.num AS "ConsecutiveNums"
            FROM   logs l,
                   logs lp,
                   logs ln
            WHERE  lp.id(+) + 1 = l.id
            AND    ln.id(+) - 1 = l.id
            AND    l.num = lp.num
            AND    l.num = ln.num

            """;
    }
}
