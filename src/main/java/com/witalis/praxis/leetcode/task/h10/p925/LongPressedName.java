package com.witalis.praxis.leetcode.task.h10.p925;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p925.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 925,
    description = "Long Pressed Name",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, TWO_POINTERS}
)
public class LongPressedName extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;

    private String name;
    private String typed;

    public static final String INFORMATION = """

        Description:
            Your friend is typing his name into a keyboard. Sometimes, when typing a character c,
                the key might get long pressed, and the character will be typed 1 or more times.
            
            You examine the typed characters of the keyboard. Return True if it is possible
                that it was your friends name, with some characters (possibly none) being long pressed.

        Example:
            Input: name = "saeed", typed = "ssaaedd"
            Output: false
            Explanation: 'e' must have been pressed twice, but it was not in the typed output.""";

    public LongPressedName(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        this.name = builder.toString();

        builder = new StringBuilder();
        for (char letter : name.toCharArray()) {
            builder.append(letter);
            int press = random.nextInt(0, 4);
            while (press-- > 0) {
                builder.append(letter);
            }
        }
        if (random.nextBoolean()) {
            int index = random.nextInt(0, builder.length());
            builder.insert(index, (char) random.nextInt('a', 'z' + 1));
        }
        this.typed = builder.toString();

        log.info("Name: '{}'", name);
        log.info("Typed: '{}'", typed);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 562 ms
    @Override
    protected Boolean original() {
        var original = new Original(name, typed);
        return original.process();
    }

    // time = 559 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(name, typed);
        return practice.process();
    }

    // time = 546 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(name, typed);
        return solution.process();
    }
}
