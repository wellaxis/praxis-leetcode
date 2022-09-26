package com.witalis.praxis.leetcode.task.h7.p620.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 620
 * Name: Not Boring Movies
 * URL: <a href="https://leetcode.com/problems/not-boring-movies/">Not Boring Movies</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Solution {

    public String process() {
        return notBoringMovies();
    }

    public String notBoringMovies() {
        return
            """

            SELECT c.*
            FROM   cinema c
            WHERE  MOD(c.id, 2) = 1
            AND    c.description != 'boring'
            ORDER BY c.rating DESC

            """;
    }
}
