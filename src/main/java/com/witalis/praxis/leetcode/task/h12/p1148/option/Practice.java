package com.witalis.praxis.leetcode.task.h12.p1148.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1148
 * Name: Article Views I
 * URL: <a href="https://leetcode.com/problems/article-views-i/">Article Views I</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return findViewedAuthors();
    }

    public String findViewedAuthors() {
        return
            """

            SELECT DISTINCT v.author_id AS id
            FROM   views v
            WHERE  v.author_id = v.viewer_id
            ORDER BY v.author_id ASC

            """;
    }
}
