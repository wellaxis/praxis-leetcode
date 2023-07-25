package com.witalis.praxis.leetcode.task.h9.p852;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p852.option.Original;
import com.witalis.praxis.leetcode.task.h9.p852.option.Practice;
import com.witalis.praxis.leetcode.task.h9.p852.option.Solution;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 852,
    description = "Peak Index in a Mountain Array",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, BINARY_SEARCH}
)
public class PeakIndexInMountainArray extends LeetCodeTask<Integer> {
    public static final int LEN = 100_000;
    public static final int VALUE = 1_000_000;

    private int[] array;

    public static final String INFORMATION = """

        Description:
            An array arr a mountain if the following properties hold:
                * arr.length >= 3
                * There exists some i with 0 < i < arr.length - 1 such that:
                    * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
                    * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

            Given a mountain array arr, return the index i such that
                arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

            You must solve it in O(log(arr.length)) time complexity.

        Example:
            Input: arr = [0,10,5,2]
            Output: 1""";

    public PeakIndexInMountainArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        List<Integer> prefix = random.ints(
            random.nextInt(1, LEN / 2),
            0, VALUE + 1
        ).distinct().sorted().boxed().toList();

        int peak = prefix.stream().max(Comparator.naturalOrder()).orElse(-1);

        List<Integer> suffix = new ArrayList<>(random.ints(
            random.nextInt(1, LEN / 2),
            0, peak
        ).distinct().boxed().toList());
        suffix.sort(Comparator.reverseOrder());

        final int size = prefix.size() + suffix.size();
        this.array = new int[size];
        int i = 0;
        for (int element : prefix) array[i++] = element;
        for (int element : suffix) array[i++] = element;

        log.info("Array: {}", Arrays.toString(array));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1094 ms
    @Override
    protected Integer original() {
        var original = new Original(array);
        return original.process();
    }

    // time = 1081 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(array);
        return practice.process();
    }

    // time = 959 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(array);
        return solution.process();
    }
}
