package com.witalis.praxis.leetcode.task.h1.p3;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p3.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 3,
    description = "Longest Substring Without Repeating Characters",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, SLIDING_WINDOW}
)
public class LongestSubstringWithoutRepeatingCharacters extends LeetCodeTask<Integer> {
    public static final int NUMBER = 500_000;
    public static final boolean randomize;
    private String string;

    public static final String INFORMATION = """

            Given a string s,
            find the length of the longest substring
            without repeating characters.""";

    static {
        randomize = false;
    }

    public LongestSubstringWithoutRepeatingCharacters(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final int leftLimit = 32;
        final int rightLimit = 122;

        var random = ThreadLocalRandom.current();
        if (randomize) {
            this.string = random.ints(leftLimit, rightLimit + 1)
                .limit(random.nextInt(0, NUMBER))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        } else {
            this.string = "abcabcbb1234abc12bc3ab";
        }
        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1585 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 1221 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 988 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
