package com.witalis.praxis.leetcode.task.h17.p1630;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h17.p1630.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1630,
    description = "Arithmetic Subarrays",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, SORTING}
)
public class ArithmeticSubarrays extends LeetCodeTask<List<Boolean>> {
    public static final int LEN = 500;
    public static final int VALUE = 100_000;

    private int[] numbers;
    private int[] left;
    private int[] right;

    public static final String INFORMATION = """

        Description:
            A sequence of numbers is called arithmetic if it consists of at least two elements,
                and the difference between every two consecutive elements is the same.
                More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.

            For example, these are arithmetic sequences:
                1, 3, 5, 7, 9
                7, 7, 7, 7
                3, -1, -5, -9

            The following sequence is not arithmetic:
                1, 1, 2, 5, 7

            You are given an array of n integers, nums, and two arrays of m integers each, l and r,
                representing the m range queries, where the ith query is the range [l[i], r[i]].
                All the arrays are 0-indexed.

            Return a list of boolean elements answer, where answer[i] is true if the subarray
                nums[l[i]], nums[l[i]+1], ... , nums[r[i]] can be rearranged to form an arithmetic sequence, and false otherwise.

        Example:
            Input: nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
            Output: [true,false,true]
            Explanation:
                In the 0th query, the subarray is [4,6,5]. This can be rearranged as [6,5,4], which is an arithmetic sequence.
                In the 1st query, the subarray is [4,6,5,9]. This cannot be rearranged as an arithmetic sequence.
                In the 2nd query, the subarray is [5,9,3,7]. This can be rearranged as [3,5,7,9], which is an arithmetic sequence.""";

    public ArithmeticSubarrays(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(2, LEN + 1);
        int m = random.nextInt(1, LEN + 1);
        this.numbers = random.ints(n, -VALUE, VALUE + 1).toArray();
        this.left = random.ints(m, 0, n).toArray();
        this.right = left.clone();
        for (int i = 0; i < m; i++)
            right[i] += random.nextInt(0, n - right[i]);

        log.info("Numbers: {}", Arrays.toString(numbers));
        log.info("Left 'l': {}", Arrays.toString(left));
        log.info("Right 'r': {}", Arrays.toString(right));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1587 ms
    @Override
    protected List<Boolean> original() {
        var original = new Original(numbers.clone(), left.clone(), right.clone());
        return original.process();
    }

    // time = 1453 ms
    @Override
    protected List<Boolean> practice() {
        var practice = new Practice(numbers.clone(), left.clone(), right.clone());
        return practice.process();
    }

    // time = 1147 ms
    @Override
    protected List<Boolean> solution() {
        var solution = new Solution(numbers.clone(), left.clone(), right.clone());
        return solution.process();
    }
}
