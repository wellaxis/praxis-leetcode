package com.witalis.praxis.leetcode.task.h7.p627;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p627.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 627,
    description = "Swap Salary",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class SwapSalary extends LeetCodeTask<String> {
    private List<String> salaries;

    public static final String INFORMATION = """

        Table: Salary
        +-------------+----------+
        | Column Name | Type     |
        +-------------+----------+
        | id          | int      |
        | name        | varchar  |
        | sex         | ENUM     |
        | salary      | int      |
        +-------------+----------+
        id is the primary key for this table.
        The sex column is ENUM value of type ('m', 'f').
        The table contains information about an employee.

        Write an SQL query to swap all 'f' and 'm' values
        (i.e., change all 'f' values to 'm' and vice versa)
        with a single update statement and no intermediate temporary tables.

        Note that you must write a single update statement,
        do not write any select statement for this problem.

        The query result format is in the following example.

        Example:
            Input:
                Salary table:
                +----+------+-----+--------+
                | id | name | sex | salary |
                +----+------+-----+--------+
                | 1  | A    | m   | 2500   |
                | 2  | B    | f   | 1500   |
                | 3  | C    | m   | 5500   |
                | 4  | D    | f   | 500    |
                +----+------+-----+--------+
            Output:
                +----+------+-----+--------+
                | id | name | sex | salary |
                +----+------+-----+--------+
                | 1  | A    | f   | 2500   |
                | 2  | B    | m   | 1500   |
                | 3  | C    | f   | 5500   |
                | 4  | D    | m   | 500    |
                +----+------+-----+--------+
            Explanation:
                (1, A) and (3, C) were changed from 'm' to 'f'.
                (2, B) and (4, D) were changed from 'f' to 'm'.""";

    public SwapSalary(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.salaries = Collections.emptyList();

        log.info("Salaries are {}", salaries);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 621 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 522 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 741 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
