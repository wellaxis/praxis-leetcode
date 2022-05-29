package com.witalis.praxis.leetcode.task.h4.p389;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p389.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 389,
    description = "Find the Difference",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING, BIT_MANIPULATION, SORTING}
)
public class FindTheDifference extends LeetCodeTask<Character> {
    public static final int LEN = 1_000;
    private String s;
    private String t;

    public static final String INFORMATION = """

        You are given two strings s and t. String t is generated by random
            shuffling string s and then add one more letter at a random position.

        Return the letter that was added to t.

        Example:
            Input: s = "abcd", t = "abcde"
            Output: "e"
            Explanation: 'e' is the letter that was added.""";

    public FindTheDifference(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(0, LEN + 1);

        List<Character> letters = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char letter = (char) random.nextInt('a', 'z' + 1);
            letters.add(letter);
        }

        this.s = letters.stream().map(String::valueOf).collect(Collectors.joining());

        letters.add((char) random.nextInt('a', 'z' + 1));
        Collections.shuffle(letters);

        this.t = letters.stream().map(String::valueOf).collect(Collectors.joining());

        log.info("String 's' is {}", s);
        log.info("String 't' is {}", t);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1219 ms
    @Override
    protected Character original() {
        var original = new Original(s, t);
        return original.process();
    }

    // time = 644 ms
    @Override
    protected Character practice() {
        var practice = new Practice(s, t);
        return practice.process();
    }

    // time = 561 ms
    @Override
    protected Character solution() {
        var solution = new Solution(s, t);
        return solution.process();
    }
}