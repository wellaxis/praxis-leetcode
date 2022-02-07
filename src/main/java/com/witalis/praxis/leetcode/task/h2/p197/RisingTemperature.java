package com.witalis.praxis.leetcode.task.h2.p197;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p197.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 197,
    description = "Rising Temperature",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class RisingTemperature extends LeetCodeTask<String> {
    private List<String> temperatures;

    public static final String INFORMATION = """

        Table: Weather
        +---------------+---------+
        | Column Name   | Type    |
        +---------------+---------+
        | id            | int     |
        | recordDate    | date    |
        | temperature   | int     |
        +---------------+---------+
        id is the primary key column for this table.
        This table contains information about the temperature on a certain day.

        Write an SQL query to find all dates' Id
            with higher temperatures compared to its previous dates (yesterday).

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                Weather table:
                +----+------------+-------------+
                | id | recordDate | temperature |
                +----+------------+-------------+
                | 1  | 2015-01-01 | 10          |
                | 2  | 2015-01-02 | 25          |
                | 3  | 2015-01-03 | 20          |
                | 4  | 2015-01-04 | 30          |
                +----+------------+-------------+
            Output:
                +----+
                | id |
                +----+
                | 2  |
                | 4  |
                +----+
            Explanation:
                In 2015-01-02, the temperature was higher than
                    the previous day (10 -> 25).
                In 2015-01-04, the temperature was higher than
                    the previous day (20 -> 30).""";

    public RisingTemperature(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.temperatures = Collections.emptyList();

        log.info("Temperatures are {}", temperatures);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 820 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 293 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 302 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
