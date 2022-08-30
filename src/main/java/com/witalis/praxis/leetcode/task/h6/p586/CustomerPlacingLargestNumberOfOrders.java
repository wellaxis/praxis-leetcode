package com.witalis.praxis.leetcode.task.h6.p586;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p586.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Collections;
import java.util.List;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 586,
    description = "Customer Placing the Largest Number of Orders",
    difficulty = TaskDifficulty.EASY,
    tags = {DATABASE}
)
public class CustomerPlacingLargestNumberOfOrders extends LeetCodeTask<String> {
    private List<String> orders;

    public static final String INFORMATION = """

        Table: Orders
        +-----------------+----------+
        | Column Name     | Type     |
        +-----------------+----------+
        | order_number    | int      |
        | customer_number | int      |
        +-----------------+----------+
        order_number is the primary key for this table.
        This table contains information about the order ID and the customer ID.

        Write an SQL query to find the customer_number for the customer who has placed the largest number of orders.

        The test cases are generated so that exactly one customer will have placed more orders than any other customer.

        The query result format is in the following example.

        Example:
            Input:
                Orders table:
                +--------------+-----------------+
                | order_number | customer_number |
                +--------------+-----------------+
                | 1            | 1               |
                | 2            | 2               |
                | 3            | 3               |
                | 4            | 3               |
                +--------------+-----------------+
            Output:
                +-----------------+
                | customer_number |
                +-----------------+
                | 3               |
                +-----------------+
            Explanation:
                The customer with number 3 has two orders,
                which is greater than either customer 1 or 2 because each of them only has one order.
                So the result is customer_number 3.""";

    public CustomerPlacingLargestNumberOfOrders(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.orders = Collections.emptyList();

        log.info("Orders are {}", orders);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 703 ms
    @Override
    protected String original() {
        var original = new Original();
        return original.process();
    }

    // time = 820 ms
    @Override
    protected String practice() {
        var practice = new Practice();
        return practice.process();
    }

    // time = 638 ms
    @Override
    protected String solution() {
        var solution = new Solution();
        return solution.process();
    }
}
