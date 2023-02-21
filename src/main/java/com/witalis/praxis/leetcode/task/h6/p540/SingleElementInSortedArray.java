package com.witalis.praxis.leetcode.task.h6.p540;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p540.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 540,
    description = "Single Element in a Sorted Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class SingleElementInSortedArray extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 100_000;

    private int[] numbers;

    public static final String INFORMATION = """

        Description:
            You are given a sorted array consisting of only integers where every element appears exactly twice,
                except for one element which appears exactly once.

            Return the single element that appears only once.

            Your solution must run in O(log n) time and O(1) space.

        Example:
            Input: nums = [3,3,7,7,10,11,11]
            Output: 10""";

    public SingleElementInSortedArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int len = random.nextInt(1, LEN + 1);
        while (len-- > list.size()) {
            int value = random.nextInt(0, VALUE + 1);
            if (!set.contains(value)) {
                set.add(value);
                list.add(value);
                list.add(value);
                len--;
            }
        }
        list.remove(list.size() - 1);
        this.numbers = list.stream().mapToInt(Integer::intValue).sorted().toArray();

        log.info("Numbers: {}", Arrays.toString(numbers));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 482 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers.clone());
        return original.process();
    }

    // time = 476 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers.clone());
        return practice.process();
    }

    // time = 463 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers.clone());
        return solution.process();
    }
}
