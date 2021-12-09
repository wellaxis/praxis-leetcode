package com.witalis.praxis.leetcode.task.p35;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.p35.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@LeetCode(id = 35, description = "Search Insert Position")
public class SearchInsertPosition extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;
    private int[] numbers;
    private int target;

    public static final String INFORMATION = """

        Given a sorted array of distinct integers and a target value,
            return the index if the target is found.
            If not, return the index where it would be if it were inserted in order.

        You must write an algorithm with O(log n) runtime complexity.

        Example:
            Input: nums = [1,3,5,6], target = 5
            Output: 2""";

    public SearchInsertPosition(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.numbers = random.ints(-VALUE, VALUE + 1)
            .distinct()
            .limit(LEN)
            .sorted()
            .toArray();

        this.target = random.nextInt(-VALUE, VALUE + 1);

        log.info("Numbers are {}", numbers);
        log.info("Target is {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 889 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers, target);
        return original.process();
    }

    // time = 691 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers, target);
        return practice.process();
    }

    // time = 791 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers, target);
        return solution.process();
    }
}
