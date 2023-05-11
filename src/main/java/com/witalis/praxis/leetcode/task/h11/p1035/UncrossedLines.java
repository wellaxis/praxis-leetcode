package com.witalis.praxis.leetcode.task.h11.p1035;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1035.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1035,
    description = "Uncrossed Lines",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING}
)
public class UncrossedLines extends LeetCodeTask<Integer> {
    public static final int LEN = 500;
    public static final int VALUE = 2_000;

    private int[] numbers1;
    private int[] numbers2;

    public static final String INFORMATION = """

        Description:
            You are given two integer arrays nums1 and nums2.
                We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.

            We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
                * nums1[i] == nums2[j], and
                * the line we draw does not intersect any other connecting (non-horizontal) line.

            Note that a connecting line cannot intersect even at the endpoints
                (i.e., each number can only belong to one connecting line).

            Return the maximum number of connecting lines we can draw in this way.

        Example:
            Input: nums1 = [1,4,2], nums2 = [1,2,4]
            Output: 2
            Explanation: We can draw 2 uncrossed lines as in the diagram.
                We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4
                will intersect the line from nums1[2]=2 to nums2[1]=2.""";

    public UncrossedLines(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.numbers1 = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.numbers2 = random.ints(
            random.nextInt(1, LEN + 1),
            1, VALUE + 1
        ).toArray();

        log.info("Numbers N1: {}", Arrays.toString(numbers1));
        log.info("Numbers N2: {}", Arrays.toString(numbers2));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1775 ms
    @Override
    protected Integer original() {
        var original = new Original(numbers1, numbers2);
        return original.process();
    }

    // time = 1420 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(numbers1, numbers2);
        return practice.process();
    }

    // time = 1282 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(numbers1, numbers2);
        return solution.process();
    }
}
