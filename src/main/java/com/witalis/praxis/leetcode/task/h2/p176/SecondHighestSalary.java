package com.witalis.praxis.leetcode.task.h2.p176;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p176.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 176,
    description = "Second Highest Salary",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DATABASE}
)
public class SecondHighestSalary extends LeetCodeTask<String> {
    private List<String> employees;

    public static final String INFORMATION = """

        Table: Employee
        +-------------+------+
        | Column Name | Type |
        +-------------+------+
        | id          | int  |
        | salary      | int  |
        +-------------+------+
        id is the primary key column for this table.
        Each row of this table contains information
            about the salary of an employee.
                
        Write an SQL query to report the second highest salary
            from the Employee table. If there is no second highest salary,
            the query should report null.

        The query result format is in the following example.

        Example:
            Input:
                Employee table:
                +----+--------+
                | id | salary |
                +----+--------+
                | 1  | 100    |
                | 2  | 200    |
                | 3  | 300    |
                +----+--------+
            Output:
                +---------------------+
                | SecondHighestSalary |
                +---------------------+
                | 200                 |
                +---------------------+""";

    public SecondHighestSalary(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.employees = Collections.emptyList();

        log.info("Employees are {}", employees);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 625 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 200 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 218 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
