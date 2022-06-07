package com.witalis.praxis.leetcode.task.h4.p344;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p344.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 344,
    description = "Reverse String",
    difficulty = TaskDifficulty.EASY,
    tags = {TWO_POINTERS, STRING, RECURSION}
)
public class ReverseString extends LeetCodeTask<String> {
    public static final int LEN = 100_000;
    private char[] characters;

    public static final String INFORMATION = """

        Write a function that reverses a string. The input string is given as an array of characters s.
                                              
        You must do this by modifying the input array in-place with O(1) extra memory.

        Example:
            Input: s = ["H","a","n","n","a","h"]
            Output: ["h","a","n","n","a","H"]""";

    public ReverseString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(0, LEN + 1);
        this.characters = new char[len];

        for (int i = 0; i < len; i++) {
            characters[i] = (char) random.nextInt('a', 'z' + 1);
        }

        log.info("Characters are {}", Arrays.toString(characters));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2105 ms
    @Override
    protected String original() {
        var original = new Original(characters.clone());
        return original.process();
    }

    // time = 2061 ms
    @Override
    protected String practice() {
        var practice = new Practice(characters.clone());
        return practice.process();
    }

    // time = 2107 ms
    @Override
    protected String solution() {
        var solution = new Solution(characters.clone());
        return solution.process();
    }
}
