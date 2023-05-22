package com.witalis.praxis.leetcode.task.h6.p577;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p577.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.DATABASE;

@Slf4j
@LeetCode(
    id = 577,
    description = "Employee Bonus",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class EmployeeBonus extends LeetCodeTask<String> {
    private List<String> bonuses;

    public static final String INFORMATION = """

        Description:
            Table: Employee
            +-------------+---------+
            | Column Name | Type    |
            +-------------+---------+
            | empId       | int     |
            | name        | varchar |
            | supervisor  | int     |
            | salary      | int     |
            +-------------+---------+
            empId is the primary key column for this table.
            Each row of this table indicates the name and the ID of an employee
            in addition to their salary and the id of their manager.

            Table: Bonus
            +-------------+------+
            | Column Name | Type |
            +-------------+------+
            | empId       | int  |
            | bonus       | int  |
            +-------------+------+
            empId is the primary key column for this table.
            empId is a foreign key to empId from the Employee table.
            Each row of this table contains the id of an employee and their respective bonus.

            Write an SQL query to report the name and bonus amount of each employee with a bonus less than 1000.

            Return the result table in any order.

            The query result format is in the following example.

        Example:
            Input:
                Employee table:
                +-------+--------+------------+--------+
                | empId | name   | supervisor | salary |
                +-------+--------+------------+--------+
                | 3     | Brad   | null       | 4000   |
                | 1     | John   | 3          | 1000   |
                | 2     | Dan    | 3          | 2000   |
                | 4     | Thomas | 3          | 4000   |
                +-------+--------+------------+--------+
                Bonus table:
                +-------+-------+
                | empId | bonus |
                +-------+-------+
                | 2     | 500   |
                | 4     | 2000  |
                +-------+-------+
            Output:
                +------+-------+
                | name | bonus |
                +------+-------+
                | Brad | null  |
                | John | null  |
                | Dan  | 500   |
                +------+-------+""";

    public EmployeeBonus(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.bonuses = Collections.emptyList();

        log.info("Bonuses: {}", bonuses);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1509 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 1436 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 1552 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
