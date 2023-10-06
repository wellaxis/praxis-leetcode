package com.witalis.praxis.leetcode.task.h2.p132;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p132.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 132,
    description = "Palindrome Partitioning II",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class PalindromePartitioningII extends LeetCodeTask<Integer> {
    public static final int LEN = 400;

    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, partition s such that every substring of the partition is a palindrome.

            Return the minimum cuts needed for a palindrome partitioning of s.

        Example:
            Input: s = "aab"
            Output: 1
            Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.""";

    public PalindromePartitioningII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String 's': '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 24292 ms, times limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 3789 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 746 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
