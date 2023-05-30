package com.witalis.praxis.leetcode.task.h9.p844;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p844.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 844,
    description = "Backspace String Compare",
    difficulty = TaskDifficulty.EASY,
    tags = {TWO_POINTERS, STRING, STACK, SIMULATION}
)
public class BackspaceStringCompare extends LeetCodeTask<Boolean> {
    public static final int LEN = 200;

    private String string1;
    private String string2;

    public static final String INFORMATION = """

        Description:
            Given two strings s and t, return true if they are equal when both are typed into empty text editors.
                '#' means a backspace character.

            Note that after backspacing an empty text, the text will continue empty.

        Example:
            Input: s = "ab#c", t = "ad#c"
            Output: true
            Explanation: Both s and t become "ac".""";

    public BackspaceStringCompare(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.string1 = generate();
        this.string2 = generate();

        log.info("String 's': {}", string1);
        log.info("String 't': {}", string2);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (random.nextInt(0, 5) == 0) {
                builder.append('#');
            } else {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 491 ms
    @Override
    protected Boolean original() {
        var original = new Original(string1, string2);
        return original.process();
    }

    // time = 484 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string1, string2);
        return practice.process();
    }

    // time = 473 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string1, string2);
        return solution.process();
    }
}
