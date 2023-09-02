package com.witalis.praxis.leetcode.task.h28.p2707;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h28.p2707.option.Original;
import com.witalis.praxis.leetcode.task.h28.p2707.option.Practice;
import com.witalis.praxis.leetcode.task.h28.p2707.option.Solution;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2707,
    description = "Extra Characters in a String",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {ARRAY, HASH_TABLE, STRING, DYNAMIC_PROGRAMMING, TRIE}
)
public class ExtraCharactersInString extends LeetCodeTask<Integer> {
    public static final int LEN = 10;
    public static final int SIZE = 1000;

    private String string;
    private String[] dictionary;

    public static final String INFORMATION = """

        Description:
            You are given a 0-indexed string s and a dictionary of words dictionary.
                You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary.
                There may be some extra characters in s which are not present in any of the substrings.

            Return the minimum number of extra characters left over if you break up s optimally.

        Example:
            Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
            Output: 1
            Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8.
                There is only 1 unused character (at index 4), so we return 1.""";

    public ExtraCharactersInString(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.string = generate();

        final var size = random.nextInt(1, SIZE + 1);
        final var words = new ArrayList<String>();
        for (int i = 0; i < size; i++)
            words.add(generate());
        this.dictionary = words.toArray(String[]::new);

        log.info("String s: '{}'", string);
        log.info("Dictionary: {}", Arrays.toString(dictionary));
    }

    private String generate() {
        final var random = ThreadLocalRandom.current();

        final var len = random.nextInt(1, LEN + 1);
        final var builder = new StringBuilder();
        for (int i = 0; i < len; i++)
            builder.append((char) random.nextInt('a', 'z' + 1));

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1045 ms
    @Override
    protected Integer original() {
        var original = new Original(string, dictionary);
        return original.process();
    }

    // time = 1026 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(string, dictionary);
        return practice.process();
    }

    // time = 2410 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(string, dictionary);
        return solution.process();
    }
}
