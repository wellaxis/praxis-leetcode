package com.witalis.praxis.leetcode.task.h10.p922;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p922.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 922,
    description = "Sort Array By Parity II",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, TWO_POINTERS, SORTING}
)
public class SortArrayByParityII extends LeetCodeTask<int[]> {
    public static final int LEN = 20_000;
    public static final int VALUE = 1_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

            Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

            Return any answer array that satisfies this condition.

        Example:
            Input: nums = [4,2,5,7]
            Output: [4,5,2,7]
            Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.""";

    public SortArrayByParityII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final int len = 2 * random.nextInt(1, LEN / 2);
        final List<Integer> list = new ArrayList<>(IntStream.rangeClosed(2, len).boxed().toList());
        Collections.shuffle(list);
        this.numbers = list.stream().mapToInt(Integer::intValue).toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1301 ms
    @Override
    protected int[] original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 1610 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 1584 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
