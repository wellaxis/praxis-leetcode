package com.witalis.praxis.leetcode.task.h4.p387;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p387.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 387,
    description = "First Unique Character in a String",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING, QUEUE, COUNTING}
)
public class FirstUniqueCharacterInString extends LeetCodeTask<Integer> {
    public static final int LEN = 500_000;
    private String string;

    public static final String INFORMATION = """

        Given a string s, find the first non-repeating character in it and return its index.
            If it does not exist, return -1.

        Example:
            Input: s = "loveleetcode"
            Output: 2""";

    public FirstUniqueCharacterInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

        List<Character> letters = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char letter = (char) random.nextInt('a', 'z' + 1);
            letters.add(letter);
        }

        this.string = letters.stream().map(String::valueOf).collect(Collectors.joining());

        log.info("String is {}", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 17971 ms
    @Override
    protected Integer original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 25493 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 26044 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
