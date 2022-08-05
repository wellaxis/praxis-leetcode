package com.witalis.praxis.leetcode.task.h2.p180;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p180.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 180,
    description = "Consecutive Numbers",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DATABASE}
)
public class ConsecutiveNumbers extends LeetCodeTask<String> {
    private List<String> logs;

    public static final String INFORMATION = """

        Table: Logs
            +-------------+---------+
            | Column Name | Type    |
            +-------------+---------+
            | id          | int     |
            | num         | varchar |
            +-------------+---------+
            id is the primary key for this table.
            id is an autoincrement column.

        Write an SQL query to find all numbers that appear at least three times consecutively.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
            Logs table:
                +----+-----+
                | id | num |
                +----+-----+
                | 1  | 1   |
                | 2  | 1   |
                | 3  | 1   |
                | 4  | 2   |
                | 5  | 1   |
                | 6  | 2   |
                | 7  | 2   |
                +----+-----+
            Output:
                +-----------------+
                | ConsecutiveNums |
                +-----------------+
                | 1               |
                +-----------------+
            Explanation: 1 is the only number that appears consecutively for at least three times.""";

    public ConsecutiveNumbers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.logs = Collections.emptyList();

        log.info("Logs are {}", logs);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 833 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 623 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 792 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
