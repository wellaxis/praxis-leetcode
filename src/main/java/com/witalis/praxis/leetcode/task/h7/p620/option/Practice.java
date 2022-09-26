package com.witalis.praxis.leetcode.task.h7.p620.option;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * ID: 620
 * Name: Not Boring Movies
 * URL: <a href="https://leetcode.com/problems/not-boring-movies/">Not Boring Movies</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
public class Practice {

    public String process() {
        return notBoringMovies();
    }

    public String notBoringMovies() {
        return
            """

            SELECT c.*
            FROM   cinema c
            WHERE  c.description NOT IN ('boring')
            AND    MOD(c.id, 2) <> 0
            ORDER BY c.rating DESC

            """;
    }
}
