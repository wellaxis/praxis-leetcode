package com.witalis.praxis.leetcode.task.h2.p175;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p175.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 175,
    description = "Combine Two Tables",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class CombineTwoTables extends LeetCodeTask<String> {
    private List<String> employees;

    public static final String INFORMATION = """

        Table: Person
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | personId    | int     |
        | lastName    | varchar |
        | firstName   | varchar |
        +-------------+---------+
        personId is the primary key column for this table.
        This table contains information about the ID
        of some persons and their first and last names.
                
        Table: Address
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | addressId   | int     |
        | personId    | int     |
        | city        | varchar |
        | state       | varchar |
        +-------------+---------+
        addressId is the primary key column for this table.
        Each row of this table contains information about
        the city and state of one person with ID = PersonId.

        Write an SQL query to report the first name, last name,
            city, and state of each person in the Person table.
            If the address of a personId is not present
            in the Address table, report null instead.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                Person table:
                +----------+----------+-----------+
                | personId | lastName | firstName |
                +----------+----------+-----------+
                | 1        | Wang     | Allen     |
                | 2        | Alice    | Bob       |
                +----------+----------+-----------+
                Address table:
                +-----------+----------+---------------+------------+
                | addressId | personId | city          | state      |
                +-----------+----------+---------------+------------+
                | 1         | 2        | New York City | New York   |
                | 2         | 3        | Leetcode      | California |
                +-----------+----------+---------------+------------+
            Output:
                +-----------+----------+---------------+----------+
                | firstName | lastName | city          | state    |
                +-----------+----------+---------------+----------+
                | Allen     | Wang     | Null          | Null     |
                | Bob       | Alice    | New York City | New York |
                +-----------+----------+---------------+----------+
            Explanation:
                There is no address in the address table for the personId = 1
                so we return null in their city and state.
                addressId = 1 contains information about the address of personId = 2.""";

    public CombineTwoTables(int id, String description, TaskRevision revision) {
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

    // time = 427 ms
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
