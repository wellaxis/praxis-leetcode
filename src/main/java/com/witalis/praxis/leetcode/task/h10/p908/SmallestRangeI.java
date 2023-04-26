package com.witalis.praxis.leetcode.task.h10.p908;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p908.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 908,
    description = "Smallest Range I",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, MATH}
)
public class SmallestRangeI extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 10_000;

    private int[] numbers;
    private int element;

    public static final String INFORMATION = """

        Description:
            You are given an integer array nums and an integer k.

            In one operation, you can choose any index i where 0 <= i < nums.length
                and change nums[i] to nums[i] + x where x is an integer from the range [-k, k].
                You can apply this operation at most once for each index i.

            The score of nums is the difference between the maximum and minimum elements in nums.

            Return the minimum score of nums after applying the mentioned operation at most once for each index in it.

        Example:
            Input: nums = [0,10], k = 2
            Output: 6
            Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.""";

    public SmallestRangeI(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers = random.ints(
            random.nextInt(1, LEN + 1),
            0, VALUE + 1)
            .toArray();
        this.element = random.nextInt(0, VALUE + 1);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Element 'k': {}", element);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 713 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone(), element);
        return original.process();
    }

    // time = 678 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone(), element);
        return practice.process();
    }

    // time = 564 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone(), element);
        return solution.process();
    }
}
