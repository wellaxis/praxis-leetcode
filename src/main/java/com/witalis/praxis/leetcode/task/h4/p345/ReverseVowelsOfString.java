package com.witalis.praxis.leetcode.task.h4.p345;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p345.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 345,
    description = "Reverse Vowels of a String",
    difficulty = TaskDifficulty.EASY,
    tags = {TWO_POINTERS, STRING}
)
public class ReverseVowelsOfString extends LeetCodeTask<String> {
    public static final int LEN = 300_000;
    private String string;

    public static final String INFORMATION = """

        Given a string s, reverse only all the vowels in the string and return it.

        The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.

        Example:
            Input: s = "leetcode"
            Output: "leotcede" """;

    public ReverseVowelsOfString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(0, LEN + 1);
        var builder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.string = builder.toString();

        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 9402 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 11101 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 6856 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
