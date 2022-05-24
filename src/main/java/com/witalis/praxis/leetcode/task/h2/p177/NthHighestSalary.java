package com.witalis.praxis.leetcode.task.h2.p177;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p177.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 177,
    description = "Nth Highest Salary",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DATABASE}
)
public class NthHighestSalary extends LeetCodeTask<String> {
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
                
        Write an SQL query to report the n-th highest salary
            from the Employee table. If there is no n-th highest salary,
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
                n = 2
            Output:
                +------------------------+
                | getNthHighestSalary(2) |
                +------------------------+
                | 200                    |
                +------------------------+""";

    public NthHighestSalary(int id, String description, TaskRevision revision) {
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

    // time = 526 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 217 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 226 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
