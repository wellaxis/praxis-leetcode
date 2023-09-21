package com.witalis.praxis.leetcode.task.h29.p2810;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h29.p2810.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2810,
    description = "Faulty Keyboard",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING, SIMULATION}
)
public class FaultyKeyboard extends LeetCodeTask<String> {
    public static final int LEN = 100;

    private String string;

    public static final String INFORMATION = """

        Description:
            Your laptop keyboard is faulty, and whenever you type a character 'i' on it,
                it reverses the string that you have written. Typing other characters works as expected.

            You are given a 0-indexed string s, and you type each character of s using your faulty keyboard.

            Return the final string that will be present on your laptop screen.

        Example:
            Input: s = "string"
            Output: "rtsng"
            Explanation:
                After typing first character, the text on the screen is "s".
                After the second character, the text is "st".
                After the third character, the text is "str".
                Since the fourth character is an 'i', the text gets reversed and becomes "rts".
                After the fifth character, the text is "rtsn".
                After the sixth character, the text is "rtsng".
                Therefore, we return "rtsng".""";

    public FaultyKeyboard(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        final var len = random.nextInt(1, LEN + 1);
        final var builder = new StringBuilder();
        builder.append((char) random.nextInt('a', 'i'));
        for (int i = 0; i < len; i++)
            if (random.nextInt(0, 5) == 0)
                builder.append('i');
            else
                builder.append((char) random.nextInt('a', 'z' + 1));

        this.string = builder.toString();

        log.info("String s: '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 484 ms
    @Override
    protected String original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 467 ms
    @Override
    protected String practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 451 ms
    @Override
    protected String solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
