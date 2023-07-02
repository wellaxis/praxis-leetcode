package com.witalis.praxis.leetcode.task.h24.p2305;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2305.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2305,
    description = "Fair Distribution of Cookies",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, BACKTRACKING, BIT_MANIPULATION, BITMASK}
)
public class FairDistributionOfCookies extends LeetCodeTask<Integer> {
    public static final int LEN = 8;
    public static final int VALUE = 100_000;

    private int[] cookies;
    private int children;

    public static final String INFORMATION = """
        Description:
            You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag.
                You are also given an integer k that denotes the number of children to distribute all the bags of cookies to.
                All the cookies in the same bag must go to the same child and cannot be split up.

            The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.

            Return the minimum unfairness of all distributions.

        Example:
            Input: cookies = [8,15,10,20,8], k = 2
            Output: 31
            Explanation: One optimal distribution is [8,15,8] and [10,20]
                - The 1st child receives [8,15,8] which has a total of 8 + 15 + 8 = 31 cookies.
                - The 2nd child receives [10,20] which has a total of 10 + 20 = 30 cookies.
                The unfairness of the distribution is max(31,30) = 31.
                It can be shown that there is no distribution with an unfairness less than 31.""";

    public FairDistributionOfCookies(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.cookies = random.ints(
            random.nextInt(2, LEN + 1),
            1, VALUE + 1
        ).toArray();
        this.children = random.nextInt(2, cookies.length);

        log.info("Cookies: {}", Arrays.toString(cookies));
        log.info("Children: {}", children);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 556 ms
    @Override
    protected Integer original() {
        var original = new Original(cookies.clone(), children);
        return original.process();
    }

    // time = 507 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(cookies.clone(), children);
        return practice.process();
    }

    // time = 472 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(cookies.clone(), children);
        return solution.process();
    }
}
