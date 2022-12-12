package com.witalis.praxis.leetcode.task.h10.p901;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p901.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 901,
    description = "Online Stock Span",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STACK, DESIGN, MONOTONIC_STACK, DATA_STREAM}
)
public class OnlineStockSpan extends LeetCodeTask<List<Integer>> {
    public static final int LEN = 10_000;
    public static final int VALUE = 100_000;

    private List<AbstractMap.SimpleEntry<String, Integer>> operations;

    public static final String INFORMATION = """

        Description:
            Design an algorithm that collects daily price quotes for some stock
                and returns the span of that stock's price for the current day.

            The span of the stock's price in one day is the maximum number
                of consecutive days (starting from that day and going backward)
                for which the stock price was less than or equal to the price of that day.

            * For example, if the prices of the stock in the last four days is [7,2,1,2]
              and the price of the stock today is 2, then the span of today is 4
              because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
            * Also, if the prices of the stock in the last four days is [7,34,1,2]
              and the price of the stock today is 8, then the span of today is 3
              because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.

            Implement the StockSpanner class:
            * StockSpanner() Initializes the object of the class.
            * int next(int price) Returns the span of the stock's price given that today's price is price.

        Example:
            Input
                ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
                [[], [100], [80], [60], [70], [60], [75], [85]]
            Output
                [null, 1, 1, 1, 2, 1, 4, 6]
            Explanation
                StockSpanner stockSpanner = new StockSpanner();
                stockSpanner.next(100); // return 1
                stockSpanner.next(80);  // return 1
                stockSpanner.next(60);  // return 1
                stockSpanner.next(70);  // return 2
                stockSpanner.next(60);  // return 1
                stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
                stockSpanner.next(85);  // return 6""";

    public OnlineStockSpan(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        operations = new ArrayList<>();
        operations.add(new AbstractMap.SimpleEntry<>("StockSpanner", null));

        int len = random.nextInt(1, LEN + 1);
        for (int i = 0; i < len; i++) {
            int value = random.nextInt(1, VALUE + 1);
            operations.add(new AbstractMap.SimpleEntry<>("next", value));
        }

        log.info("Operations are: {}", operations);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5180 ms
    @Override
    protected List<Integer> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 4266 ms
    @Override
    protected List<Integer> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 4361 ms
    @Override
    protected List<Integer> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
