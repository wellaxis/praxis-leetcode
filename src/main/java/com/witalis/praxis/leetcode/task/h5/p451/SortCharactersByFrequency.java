package com.witalis.praxis.leetcode.task.h5.p451;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h5.p451.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 451,
    description = "Sort Characters By Frequency",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, HASH_TABLE, SORTING, HEAP, BUCKET_SORT, COUNTING}
)
public class SortCharactersByFrequency extends LeetCodeTask<String> {
    public static final int LEN = 500_000;
    private String string;

    public static final String INFORMATION = """

        Description:
            Given a string s, sort it in decreasing order based on the frequency of the characters.
                The frequency of a character is the number of times it appears in the string.

            Return the sorted string. If there are multiple answers, return any of them.

        Example:
            Input: s = "Aabb"
            Output: "bbAa"
            Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
                Note that 'A' and 'a' are treated as two different characters.""";

    public SortCharactersByFrequency(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            switch (random.nextInt(0, 3)) {
                case 0 -> builder.append((char) random.nextInt('A', 'Z' + 1));
                case 1 -> builder.append((char) random.nextInt('a', 'z' + 1));
                case 2 -> builder.append(random.nextInt(0, 10));
                default -> throw new IllegalStateException("Unexpected value: " + random.nextInt(0, 3));
            };
        }
        this.string = builder.toString();

        log.info("String 's' is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 60395 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 16618 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 8138 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
