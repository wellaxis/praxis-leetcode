package com.witalis.praxis.leetcode.task.h2.p183;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p183.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 183,
    description = "Customers Who Never Order",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class CustomersWhoNeverOrder extends LeetCodeTask<String> {
    private List<String> customers;

    public static final String INFORMATION = """

        Table: Customers
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | id          | int     |
        | name        | varchar |
        +-------------+---------+
        id is the primary key column for this table.
            Each row of this table indicates the ID
            and name of a customer.

        Table: Orders
        +-------------+---------+
        | Column Name | Type    |
        +-------------+---------+
        | id          | int     |
        | customerId  | int     |
        +-------------+---------+
        id is the primary key column for this table.
            customerId is a foreign key of the ID from the Customers table.
            Each row of this table indicates the ID of an order
            and the ID of the customer who ordered it.

        Write an SQL query to report all customers who never order anything.

        Return the result table in any order.

        The query result format is in the following example.

        Example:
            Input:
                Customers table:
                +----+-------+
                | id | name  |
                +----+-------+
                | 1  | Joe   |
                | 2  | Henry |
                | 3  | Sam   |
                | 4  | Max   |
                +----+-------+
                Orders table:
                +----+------------+
                | id | customerId |
                +----+------------+
                | 1  | 3          |
                | 2  | 1          |
                +----+------------+
            Output:
                +-----------+
                | Customers |
                +-----------+
                | Henry     |
                | Max       |
                +-----------+""";

    public CustomersWhoNeverOrder(int id, String description, TaskRevision revision) {
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

    // time = 554 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 543 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 573 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
