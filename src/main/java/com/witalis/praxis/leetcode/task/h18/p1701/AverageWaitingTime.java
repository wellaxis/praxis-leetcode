package com.witalis.praxis.leetcode.task.h18.p1701;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h18.p1701.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1701,
    description = "Average Waiting Time",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, SIMULATION}
)
public class AverageWaitingTime extends LeetCodeTask<Double> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;

    private int[][] customers;

    public static final String INFORMATION = """

        Description:
            There is a restaurant with a single chef.
                You are given an array customers, where customers[i] = [arrival^i, time^i]:
                * arrival^i is the arrival time of the i^th customer. The arrival times are sorted in non-decreasing order.
                * time^i is the time needed to prepare the order of the i^th customer.

            When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle.
                The customer waits till the chef finishes preparing his order.
                The chef does not prepare food for more than one customer at a time.
                The chef prepares food for customers in the order they were given in the input.

            Return the average waiting time of all customers.
                Solutions within 10^-5 from the actual answer are considered accepted.

        Example:
            Input: customers = [[1,2],[2,5],[4,3]]
            Output: 5.00000
            Explanation:
                1) The first customer arrives at time 1, the chef takes his order and starts preparing it immediately at time 1,
                   and finishes at time 3, so the waiting time of the first customer is 3 - 1 = 2.
                2) The second customer arrives at time 2, the chef takes his order and starts preparing it at time 3,
                   and finishes at time 8, so the waiting time of the second customer is 8 - 2 = 6.
                3) The third customer arrives at time 4, the chef takes his order and starts preparing it at time 8,
                   and finishes at time 11, so the waiting time of the third customer is 11 - 4 = 7.
                So the average waiting time = (2 + 6 + 7) / 3 = 5.""";

    public AverageWaitingTime(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int[] arrivals = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).sorted().toArray();

        int len = arrivals.length;
        this.customers = new int[len][2];
        for (int i = 0; i < len; i++) {
            customers[i] = new int[] {
                arrivals[i],
                random.nextInt(1, VALUE + 1)
            };
        }

        log.info("Customers orders:");
        StringBuilder builder = new StringBuilder();
        for (int[] customer : customers) {
            builder.append(Arrays.toString(customer));
        }
        log.info("{}", builder);
    }

    private static int[][] cloneMatrix(int[][] matrix) {
        int[][] clone = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++)
            clone[i] = matrix[i].clone();
        return clone;
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1989 ms
    @Override
    protected Double original() {
        var original = new Original(customers);
        return original.process();
    }

    // time = 1791 ms
    @Override
    protected Double practice() {
        var practice = new Practice(customers);
        return practice.process();
    }

    // time = 1740 ms
    @Override
    protected Double solution() {
        var solution = new Solution(customers);
        return solution.process();
    }
}
