package com.witalis.praxis.leetcode.task.h11.p1095;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1095.content.*;
import com.witalis.praxis.leetcode.task.h11.p1095.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1095,
    description = "Find in Mountain Array",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BINARY_SEARCH, INTERACTIVE}
)
public class FindInMountainArray extends LeetCodeTask<Integer> {
    public static final int LEN = 10_000;
    public static final int VALUE = 1_000_000_000;

    private int target;
    private MountainArray mountainArray;

    public static final String INFORMATION = """

        Description:
            (This problem is an interactive problem.)

            You may recall that an array arr is a mountain array if and only if:
                * arr.length >= 3
                * There exists some i with 0 < i < arr.length - 1 such that:
                    * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
                    * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

            Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target.
                If such an index does not exist, return -1.

            You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
                * MountainArray.get(k) returns the element of the array at index k (0-indexed).
                * MountainArray.length() returns the length of the array.

            Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer.
                Also, any solutions that attempt to circumvent the judge will result in disqualification.

        Example:
            Input: array = [1,2,3,4,5,3,1], target = 3
            Output: 2
            Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.""";

    public FindInMountainArray(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int[] array = random.ints(
            random.nextInt(3, LEN + 1),
            0, VALUE + 1
        ).toArray();
        this.mountainArray = new MountainArrayImpl(array);
        this.target = random.nextInt(0, VALUE + 1);

        log.info("Mountain array: {}", mountainArray);
        log.info("Target value: {}", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 785 ms
    @Override
    protected Integer original() {
        var original = new Original(target, mountainArray);
        return original.process();
    }

    // time = 709 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(target, mountainArray);
        return practice.process();
    }

    // time = 681 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(target, mountainArray);
        return solution.process();
    }
}
