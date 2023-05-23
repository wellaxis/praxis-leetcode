package com.witalis.praxis.leetcode.task.h7.p610.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 610
 * Name: Triangle Judgement
 * URL: <a href="https://leetcode.com/problems/triangle-judgement/description/">Triangle Judgement</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return triangleJudgement();
    }

    public String triangleJudgement() {
        return
            """

            SELECT t.x,
                   t.y,
                   t.z,
                   CASE WHEN t.sum - t.max > t.max
                       THEN 'Yes'
                       ELSE 'No'
                   END AS triangle
            FROM (
                SELECT t.x,
                       t.y,
                       t.z,
                       GREATEST(t.x, t.y, t.z) AS max,
                       t.x + t.y + t.z AS sum
                FROM   triangle t
            ) t

            """;
    }
}
