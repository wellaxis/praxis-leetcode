package com.witalis.praxis.leetcode.task.h6.p584;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p584.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 584,
    description = "Find Customer Referee",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class FindCustomerReferee extends LeetCodeTask<String> {
    private List<String> customers;

    public static final String INFORMATION = """

        Table: Customer
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | id          | int     |
        | name        | varchar |
        | referee_id  | int     |
        +-------------+---------+
        id is the primary key column for this table.
        Each row of this table indicates the id of a customer, their name, and the id of the customer who referred them.

        Write an SQL query to report the names of the customer that are not referred by the customer with id = 2.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                Customer table:
                +----+------+------------+
                | id | name | referee_id |
                +----+------+------------+
                | 1  | Will | null       |
                | 2  | Jane | null       |
                | 3  | Alex | 2          |
                | 4  | Bill | null       |
                | 5  | Zack | 1          |
                | 6  | Mark | 2          |
                +----+------+------------+
            Output:
                +------+
                | name |
                +------+
                | Will |
                | Jane |
                | Bill |
                | Zack |
                +------+""";

    public FindCustomerReferee(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.customers = Collections.emptyList();

        log.info("Customers are {}", customers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 709 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 646 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 654 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
