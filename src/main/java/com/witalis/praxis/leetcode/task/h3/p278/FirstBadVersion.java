package com.witalis.praxis.leetcode.task.h3.p278;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p278.content.*;
import com.witalis.praxis.leetcode.task.h3.p278.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 278,
    description = "First Bad Version",
    difficulty = TaskDifficulty.EASY,
    tags = {BINARY_SEARCH, INTERACTIVE}
)
public class FirstBadVersion extends LeetCodeTask<Integer> {
    private int maxVersion;

    public static final String INFORMATION = """

        Description:
            You are a product manager and currently leading a team to develop a new product.
                Unfortunately, the latest version of your product fails the quality check.
                Since each version is developed based on the previous version,
                all the versions after a bad version are also bad.

            Suppose you have n versions [1, 2, ..., n] and you want to find out
                the first bad one, which causes all the following ones to be bad.

            You are given an API bool isBadVersion(version) which returns whether version is bad.
                Implement a function to find the first bad version.
                You should minimize the number of calls to the API.

        Example:
            Input: n = 5, bad = 4
            Output: 4
            Explanation:
                call isBadVersion(3) -> false
                call isBadVersion(5) -> true
                call isBadVersion(4) -> true
                Then 4 is the first bad version.""";

    public FirstBadVersion(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        this.maxVersion = random.nextInt(1, Integer.MAX_VALUE);

        int badVersion = random.nextInt(1, maxVersion + 1);
        VersionControl.setBadVersion(badVersion);

        log.info("Max version is {}", maxVersion);
        log.info("Bad version is {}", badVersion);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 539 ms
    @Override
    protected Integer original() {
        var original = new Original(maxVersion);
        return original.process();
    }

    // time = 436 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(maxVersion);
        return practice.process();
    }

    // time = 344 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(maxVersion);
        return solution.process();
    }
}
