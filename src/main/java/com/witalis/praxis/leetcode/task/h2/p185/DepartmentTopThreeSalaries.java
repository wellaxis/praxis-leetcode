package com.witalis.praxis.leetcode.task.h2.p185;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p185.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 185,
    description = "Department Top Three Salaries",
    difficulty = TaskDifficulty.HARD,
    tags = {DATABASE}
)
public class DepartmentTopThreeSalaries extends LeetCodeTask<String> {
    private List<String> departments;

    public static final String INFORMATION = """

        Table: Employee
            +--------------+---------+
            | Column Name  | Type    |
            +--------------+---------+
            | id           | int     |
            | name         | varchar |
            | salary       | int     |
            | departmentId | int     |
            +--------------+---------+
            id is the primary key column for this table.
            departmentId is a foreign key of the ID from the Department table.
            Each row of this table indicates the ID, name, and salary of an employee.
            It also contains the ID of their department.
                                                            
        Table: Department
            +-------------+---------+
            | Column Name | Type    |
            +-------------+---------+
            | id          | int     |
            | name        | varchar |
            +-------------+---------+
            id is the primary key column for this table.
            Each row of this table indicates the ID of a department and its name.

        A company's executives are interested in seeing who earns the most money in each of the company's departments.
            A high earner in a department is an employee who has a salary in the top three unique salaries for that department.

        Write an SQL query to find the employees who are high earners in each of the departments.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                Employee table:
                +----+-------+--------+--------------+
                | id | name  | salary | departmentId |
                +----+-------+--------+--------------+
                | 1  | Joe   | 85000  | 1            |
                | 2  | Henry | 80000  | 2            |
                | 3  | Sam   | 60000  | 2            |
                | 4  | Max   | 90000  | 1            |
                | 5  | Janet | 69000  | 1            |
                | 6  | Randy | 85000  | 1            |
                | 7  | Will  | 70000  | 1            |
                +----+-------+--------+--------------+
                Department table:
                +----+-------+
                | id | name  |
                +----+-------+
                | 1  | IT    |
                | 2  | Sales |
                +----+-------+
            Output:
                +------------+----------+--------+
                | Department | Employee | Salary |
                +------------+----------+--------+
                | IT         | Max      | 90000  |
                | IT         | Joe      | 85000  |
                | IT         | Randy    | 85000  |
                | IT         | Will     | 70000  |
                | Sales      | Henry    | 80000  |
                | Sales      | Sam      | 60000  |
                +------------+----------+--------+
            Explanation:
                In the IT department:
                - Max earns the highest unique salary
                - Both Randy and Joe earn the second-highest unique salary
                - Will earns the third-highest unique salary

                In the Sales department:
                - Henry earns the highest salary
                - Sam earns the second-highest salary
                - There is no third-highest salary as there are only two employees""";

    public DepartmentTopThreeSalaries(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.departments = Collections.emptyList();

        log.info("Departments are {}", departments);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1381 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 961 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 1067 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
