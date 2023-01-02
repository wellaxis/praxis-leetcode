package com.witalis.praxis.leetcode.task.h19.p1801;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h19.p1801.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1801,
    description = "Number of Orders in the Backlog",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HEAP, SIMULATION}
)
public class NumberOfOrdersInBacklog extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = (int) Math.pow(10, 9);
    private int[][] orders;

    public static final String INFORMATION = """

        Description:
            You are given a 2D integer array orders, where each orders[i] = [price[i], amount[i], orderType[i]] denotes
                that amount[i] orders have been placed of type orderType[i] at the price price[i]. The orderType[i] is:
                * 0 if it is a batch of buy orders, or
                * 1 if it is a batch of sell orders.

            Note that orders[i] represents a batch of amount[i] independent orders with the same price and order type.
                All orders represented by orders[i] will be placed before all orders represented by orders[i+1] for all valid i.

            There is a backlog that consists of orders that have not been executed. The backlog is initially empty.
                When an order is placed, the following happens:
                * If the order is a buy order, you look at the sell order with the smallest price in the backlog.
                  If that sell order's price is smaller than or equal to the current buy order's price, they will match and be executed,
                  and that sell order will be removed from the backlog. Else, the buy order is added to the backlog.
                * Vice versa, if the order is a sell order, you look at the buy order with the largest price in the backlog.
                  If that buy order's price is larger than or equal to the current sell order's price, they will match and be executed,
                  and that buy order will be removed from the backlog. Else, the sell order is added to the backlog.

            Return the total amount of orders in the backlog after placing all the orders from the input.
                Since this number can be large, return it modulo 109 + 7.

        Example:
            Input: orders = [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]
            Output: 999999984
            Explanation: Here is what happens with the orders:
                - 109 orders of type sell with price 7 are placed. There are no buy orders, so the 109 orders are added to the backlog.
                - 3 orders of type buy with price 15 are placed. They are matched with the 3 sell orders with the least price which is 7, and those 3 sell orders are removed from the backlog.
                - 999999995 orders of type buy with price 5 are placed. The least price of a sell order is 7, so the 999999995 orders are added to the backlog.
                - 1 order of type sell with price 5 is placed. It is matched with the buy order of the highest price, which is 5, and that buy order is removed from the backlog.
                Finally, the backlog has (1000000000-3) sell orders with price 7, and (999999995-1) buy orders with price 5.
                So the total number of orders = 1999999991, which is equal to 999999984 % (109 + 7).""";

    public NumberOfOrdersInBacklog(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.orders = new int[len][];
        for (int i = 0; i < len; i++) {
            orders[i] = new int[] {
                random.nextInt(1, VALUE + 1),
                random.nextInt(1, VALUE + 1),
                random.nextBoolean() ? 0 : 1
            };
        }

        log.info("Orders: {}", Arrays.deepToString(orders));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 20975 ms
    @Override
    protected Integer original() {
        var original = new Original(orders);
        return original.process();
    }

    // time = 20142 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(orders);
        return practice.process();
    }

    // time = 5022 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(orders);
        return solution.process();
    }
}
