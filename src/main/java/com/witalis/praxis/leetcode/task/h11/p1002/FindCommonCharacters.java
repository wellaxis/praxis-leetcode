package com.witalis.praxis.leetcode.task.h11.p1002;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h11.p1002.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1002,
    description = "Find Common Characters",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class FindCommonCharacters extends LeetCodeTask<List<String>> {
    public static final int LEN = 100;

    private String[] words;

    public static final String INFORMATION = """

        Description:
            Given a string array words, return an array of all characters that
                show up in all strings within the words (including duplicates).
                You may return the answer in any order.

        Example:
            Input: words = ["bella","label","roller"]
            Output: ["e","l","l"]""";

    public FindCommonCharacters(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        this.words = new String[len];
        for (int i = 0; i < len; i++)
            words[i] = generate();

        log.info("Words: {}", Arrays.toString(words));
    }

    private String generate() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len; i++)
            builder.append((char) random.nextInt('a', 'z' + 1));

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1710 ms
    @Override
    protected List<String> original() {
        var original = new Original(words);
        return original.process();
    }

    // time = 501 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(words);
        return practice.process();
    }

    // time = 489 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(words);
        return solution.process();
    }
}
