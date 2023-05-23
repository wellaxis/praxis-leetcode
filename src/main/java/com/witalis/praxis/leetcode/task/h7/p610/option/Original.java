package com.witalis.praxis.leetcode.task.h7.p610.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 610
 * Name: Triangle Judgement
 * URL: <a href="https://leetcode.com/problems/triangle-judgement/description/">Triangle Judgement</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Original {

    public String process() {
        return triangleJudgement();
    }

    public String triangleJudgement() {
        return
            """

            SELECT t.x,
                   t.y,
                   t.z,
                   CASE
                       WHEN t.x + t.y <= t.z THEN 'No'
                       WHEN t.x + t.z <= t.y THEN 'No'
                       WHEN t.y + t.z <= t.x THEN 'No'
                       ELSE 'Yes'
                   END AS triangle
            FROM   triangle t

            """;
    }
}
