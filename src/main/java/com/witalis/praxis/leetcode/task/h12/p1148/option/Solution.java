package com.witalis.praxis.leetcode.task.h12.p1148.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 1148
 * Name: Article Views I
 * URL: <a href="https://leetcode.com/problems/article-views-i/">Article Views I</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return findViewedAuthors();
    }

    public String findViewedAuthors() {
        return
            """

            SELECT UNIQUE author_id AS id
            FROM   views
            WHERE  viewer_id = author_id
            ORDER BY author_id ASC

            """;
    }
}
