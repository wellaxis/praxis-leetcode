package com.witalis.praxis.leetcode.task.p181;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p181.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.DATABASE;

@Slf4j
@LeetCode(
    id = 181,
    description = "Employees Earning More Than Their Managers",
    tags = {DATABASE}
)
public class EmployeesEarningMoreThanTheirManagers extends LeetCodeTask<String> {
    private List<String> employees;

    public static final String INFORMATION = """

        Table: Employee
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | id          | int     |
        | name        | varchar |
        | salary      | int     |
        | managerId   | int     |
        +-------------+---------+
        id is the primary key column for this table.
            Each row of this table indicates the ID of an employee,
            their name, salary, and the ID of their manager.

        Write an SQL query to find the employees
            who earn more than their managers.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
            Employee table:
            +----+-------+--------+-----------+
            | id | name  | salary | managerId |
            +----+-------+--------+-----------+
            | 1  | Joe   | 70000  | 3         |
            | 2  | Henry | 80000  | 4         |
            | 3  | Sam   | 60000  | Null      |
            | 4  | Max   | 90000  | Null      |
            +----+-------+--------+-----------+
            Output:
            +----------+
            | Employee |
            +----------+
            | Joe      |
            +----------+
            Explanation: Joe is the only employee
                who earns more than his manager.""";

    public EmployeesEarningMoreThanTheirManagers(int id, String description, TaskRevision revision) {
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
