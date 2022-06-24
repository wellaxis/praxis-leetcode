package com.witalis.praxis.leetcode.task.h5.p409;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p409.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 409,
    description = "Longest Palindrome",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING, GREEDY}
)
public class LongestPalindrome extends LeetCodeTask<Integer> {
    public static final int LEN = 2000;
    private String string;

    public static final String INFORMATION = """

        Given a string s which consists of lowercase or uppercase letters,
            return the length of the longest palindrome that can be built with those letters.

        Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

        Example:
            Input: s = "abccccdd"
            Output: 7
            Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.""";

    public LongestPalindrome(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);

        StringBuilder builder = new StringBuilder();

        for (int s = 0; s < len; s++) {
            if (random.nextBoolean()) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            } else {
                builder.append((char) random.nextInt('A', 'Z' + 1));
            }
        }

        this.string = builder.toString();

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 828 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 489 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 407 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
