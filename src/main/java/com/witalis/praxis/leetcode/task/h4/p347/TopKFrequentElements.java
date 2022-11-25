package com.witalis.praxis.leetcode.task.h4.p347;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p347.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 347,
    description = "Top K Frequent Elements",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, DIVIDE_AND_CONQUER, SORTING, HEAP, BUCKET_SORT, COUNTING, QUICK_SORT}
)
public class TopKFrequentElements extends LeetCodeTask<int[]> {
    public static final int LEN = 100_000;
    public static final int VALUE = 10_000;
    private int[] numbers;
    private int quantity;

    public static final String INFORMATION = """

        Description:
            Given an integer array nums and an integer k, return the k most frequent elements.
                You may return the answer in any order.

        Example:
            Input: nums = [1,1,1,2,2,3], k = 2
            Output: [1,2]""";

    public TopKFrequentElements(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        List<Integer> nums = new ArrayList<>();
        int len = random.nextInt(1, LEN + 1);
        while (len > 0) {
            nums.addAll(
                Collections.nCopies(
                    random.nextInt(1, 100),
                    random.nextInt(-VALUE, VALUE + 1)
                )
            );
            len--;
        }
        Collections.shuffle(nums);
        this.numbers = nums.stream().mapToInt(Integer::intValue).toArray();
        this.quantity = random.nextInt(1, (int) nums.stream().distinct().count() + 1);

        log.info("Numbers are {}", Arrays.toString(numbers));
        log.info("Quantity k is {}", quantity);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 67187 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers, quantity);
        return original.process();
    }

    // time = 42071 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers, quantity);
        return practice.process();
    }

    // time = 4712 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers, quantity);
        return solution.process();
    }
}
