package com.witalis.praxis.leetcode.task.h12.p1122;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1122.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1122,
    description = "Relative Sort Array",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, SORTING, COUNTING_SORT}
)
public class RelativeSortArray extends LeetCodeTask<int[]> {
    public static final int LEN = 1_000;
    public static final int VALUE = 1_000;

    private int[] array1;
    private int[] array2;

    public static final String INFORMATION = """

        Description:
            Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

            Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
                Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

        Example:
            Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
            Output: [2,2,2,1,4,3,3,9,6,7,19]""";

    public RelativeSortArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.array2 = random.ints(
            random.nextInt(1, LEN / 2),
            0, VALUE + 1
        ).distinct().toArray();

        var numbers = new ArrayList<Integer>();
        for (int number : array2)
            numbers.add(number);

        int n = random.nextInt(LEN - array2.length, LEN + 1);
        for (int i = 0; i < n; i++)
            numbers.add(random.nextInt(0, VALUE + 1));

        Collections.shuffle(numbers);
        this.array1 = numbers.stream().mapToInt(Integer::intValue).toArray();

        log.info("Array #1: {}", Arrays.toString(array1));
        log.info("Array #2: {}", Arrays.toString(array2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 992 ms
    @Override
    protected int[] original() {
        var original = new Original(array1.clone(), array2.clone());
        return original.process();
    }

    // time = 938 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(array1.clone(), array2.clone());
        return practice.process();
    }

    // time = 591 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(array1.clone(), array2.clone());
        return solution.process();
    }
}
