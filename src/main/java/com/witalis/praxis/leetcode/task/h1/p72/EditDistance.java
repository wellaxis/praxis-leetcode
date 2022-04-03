package com.witalis.praxis.leetcode.task.h1.p72;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p72.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 72,
    description = "Edit Distance",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, DYNAMIC_PROGRAMMING}
)
public class EditDistance extends LeetCodeTask<Integer> {
    public static final int LEN = 500;
    private String word1;
    private String word2;

    public static final String INFORMATION = """

        Given two strings word1 and word2,
            return the minimum number of operations
            required to convert word1 to word2.

        You have the following three operations permitted on a word:
            * Insert a character
            * Delete a character
            *Replace a character
        Example:
            Input:
                word1 = "intention", word2 = "execution"
            Output:
                5
            Explanation:
                intention -> inention (remove 't')
                inention -> enention (replace 'i' with 'e')
                enention -> exention (replace 'n' with 'x')
                exention -> exection (replace 'n' with 'c')
                exection -> execution (insert 'u')""";

    public EditDistance(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.word1 = initializeWord();
        this.word2 = initializeWord();

        log.info("Word1 is '{}'", word1);
        log.info("Word2 is '{}'", word2);
    }

    private String initializeWord() {
        var random = ThreadLocalRandom.current();
        var len = random.nextInt(0, LEN + 1);
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3201907 ms, time limit exceeded
    @Override
    protected Integer original() {
        var original = new Original(word1, word2);
        return original.process();
    }

    // time = 668 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(word1, word2);
        return practice.process();
    }

    // time = 427 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(word1, word2);
        return solution.process();
    }
}
