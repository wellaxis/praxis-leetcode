package com.witalis.praxis.leetcode.task.h14.p1347;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h14.p1347.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1347,
    description = "Minimum Number of Steps to Make Two Strings Anagram",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, COUNTING}
)
public class MinimumNumberOfStepsToMakeTwoStringsAnagram extends LeetCodeTask<Integer> {
    public static final int LEN = 50_000;

    private String source;
    private String target;

    public static final String INFORMATION = """

        Description:
            You are given two strings of the same length s and t.
                In one step you can choose any character of t and replace it with another character.

            Return the minimum number of steps to make t an anagram of s.

            An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

        Example:
            Input: s = "bab", t = "aba"
            Output: 1
            Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.""";

    public MinimumNumberOfStepsToMakeTwoStringsAnagram(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int n = random.nextInt(1, LEN + 1);
        var s = new StringBuilder();
        var t = new StringBuilder();
        while (n-- > 0) {
            s.append((char) random.nextInt('a', 'z' + 1));
            t.append((char) random.nextInt('a', 'z' + 1));
        }
        this.source = s.toString();
        this.target = t.toString();

        log.info("Source: '{}'", source);
        log.info("Target: '{}'", target);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2751 ms
    @Override
    protected Integer original() {
        var original = new Original(source, target);
        return original.process();
    }

    // time = 2718 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(source, target);
        return practice.process();
    }

    // time = 2462 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(source, target);
        return solution.process();
    }
}
