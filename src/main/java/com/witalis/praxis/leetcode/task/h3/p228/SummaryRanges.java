package com.witalis.praxis.leetcode.task.h3.p228;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p228.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 228,
    description = "Summary Ranges",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY}
)
public class SummaryRanges extends LeetCodeTask<List<String>> {
    public static final int LEN = 20;
    private int[] numbers;

    public static final String INFORMATION = """

        You are given a sorted unique integer array nums.

        A range [a,b] is the set of all integers from a to b (inclusive).

        Return the smallest sorted list of ranges that
            cover all the numbers in the array exactly.
            That is, each element of nums is covered
            by exactly one of the ranges, and there is no integer x
            such that x is in one of the ranges but not in nums.

        Each range [a,b] in the list should be output as:
            * "a->b" if a != b
            * "a" if a == b

        Example:
            Input: nums = [0,2,3,4,6,8,9]
            Output: ["0","2->4","6","8->9"]
            Explanation: The ranges are:
                         [0,0] --> "0"
                         [2,4] --> "2->4"
                         [6,6] --> "6"
                         [8,9] --> "8->9" """;

    public SummaryRanges(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
                random.nextInt(1, LEN + 1),
                Integer.MIN_VALUE,
                Integer.MAX_VALUE
            )
            .distinct()
            .sorted()
            .toArray();

        log.info("Numbers are {}", numbers);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 853 ms
    @Override
    protected List<String> original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 805 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 822 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
