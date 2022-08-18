package com.witalis.praxis.leetcode.task.h6.p595;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p595.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.DATABASE;

@Slf4j
@LeetCode(
    id = 595,
    description = "Big Countries",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class BigCountries extends LeetCodeTask<String> {
    private List<String> countries;

    public static final String INFORMATION = """

        Table: World
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | name        | varchar |
        | continent   | varchar |
        | area        | int     |
        | population  | int     |
        | gdp         | int     |
        +-------------+---------+
        name is the primary key column for this table.
        Each row of this table gives information about the name of a country,
            the continent to which it belongs, its area, the population, and its GDP value.

        A country is big if:
        * it has an area of at least three million (i.e., 3000000 km2), or
        * it has a population of at least twenty-five million (i.e., 25000000).

        Write an SQL query to report the name, population, and area of the big countries.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                World table:
                +-------------+-----------+---------+------------+--------------+
                | name        | continent | area    | population | gdp          |
                +-------------+-----------+---------+------------+--------------+
                | Afghanistan | Asia      | 652230  | 25500100   | 20343000000  |
                | Albania     | Europe    | 28748   | 2831741    | 12960000000  |
                | Algeria     | Africa    | 2381741 | 37100000   | 188681000000 |
                | Andorra     | Europe    | 468     | 78115      | 3712000000   |
                | Angola      | Africa    | 1246700 | 20609294   | 100990000000 |
                +-------------+-----------+---------+------------+--------------+
            Output:
                +-------------+------------+---------+
                | name        | population | area    |
                +-------------+------------+---------+
                | Afghanistan | 25500100   | 652230  |
                | Algeria     | 37100000   | 2381741 |
                +-------------+------------+---------+""";

    public BigCountries(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.countries = Collections.emptyList();

        log.info("Countries are {}", countries);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 917 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 423 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 538 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
