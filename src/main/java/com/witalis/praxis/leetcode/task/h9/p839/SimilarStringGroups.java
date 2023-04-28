package com.witalis.praxis.leetcode.task.h9.p839;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h9.p839.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 839,
    description = "Similar String Groups",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, STRING, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND}
)
public class SimilarStringGroups extends LeetCodeTask<Integer> {
    public static final int LEN = 300;

    private String[] strings;

    public static final String INFORMATION = """

        Description:
            Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
                Also two strings X and Y are similar if they are equal.

            For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar,
                but "star" is not similar to "tars", "rats", or "arts".

            Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.
                Notice that "tars" and "arts" are in the same group even though they are not similar.
                Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.

            We are given a list strs of strings where every string in strs is an anagram of every other string in strs.
                How many groups are there?

        Example:
            Input: strs = ["tars","rats","arts","star"]
            Output: 2""";

    public SimilarStringGroups(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, LEN + 1);
        this.strings = new String[size];
        for (int i = 0; i < size; i++) {
            var builder = new StringBuilder();
            int len = random.nextInt(1, LEN + 1);
            for (int j = 0; j < len; j++) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
            strings[i] = builder.toString();
        }

        log.info("Strings: {}", Arrays.toString(strings));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2572 ms
    @Override
    protected Integer original() {
        var original = new Original(strings);
        return original.process();
    }

    // time = 2146 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(strings);
        return practice.process();
    }

    // time = 1687 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(strings);
        return solution.process();
    }
}
