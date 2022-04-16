package com.witalis.praxis.leetcode.task.h5.p455;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p455.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 455,
    description = "Assign Cookies",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, GREEDY, SORTING}
)
public class AssignCookies extends LeetCodeTask<Integer> {
    public static final int LEN = 30_000;
    private int[] factors;
    private int[] cookies;

    public static final String INFORMATION = """

        Assume you are an awesome parent and want to give your children some cookies.
            But, you should give each child at most one cookie.

        Each child i has a greed factor g[i], which is the minimum size of a cookie
            that the child will be content with; and each cookie j has a size s[j].
            If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
            Your goal is to maximize the number of your content children and output the maximum number.

        Example:
            Input: g = [1,2,3], s = [1,1]
            Output: 1
            Explanation:
                You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
                And even though you have 2 cookies, since their size is both 1,
                you could only make the child whose greed factor is 1 content.
                You need to output 1.""";

    public AssignCookies(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.factors = random.ints(
            random.nextLong(1, LEN + 1),
            1,
            Integer.MAX_VALUE
        ).toArray();
        log.info("Greed factors are {}", Arrays.toString(factors));

        this.cookies = random.ints(
            random.nextLong(0, LEN + 1),
            1,
            Integer.MAX_VALUE
        ).toArray();
        log.info("Cookies are {}", Arrays.toString(cookies));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2658 ms
    @Override
    protected Integer original() {
        var original = new Original(factors.clone(), cookies.clone());
        return original.process();
    }

    // time = 2647 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(factors.clone(), cookies.clone());
        return practice.process();
    }

    // time = 2633 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(factors.clone(), cookies.clone());
        return solution.process();
    }
}
