package com.witalis.praxis.leetcode.task.h10.p953;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h10.p953.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 953,
    description = "Verifying an Alien Dictionary",
    difficulty = TaskDifficulty.EASY,
    tags = {ARRAY, HASH_TABLE, STRING}
)
public class VerifyingAlienDictionary extends LeetCodeTask<Boolean> {
    public static final int SIZE = 100;
    public static final int LEN = 20;
    private String[] words;
    private String order;

    public static final String INFORMATION = """

        Description:
            In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
                The order of the alphabet is some permutation of lowercase letters.

            Given a sequence of words written in the alien language, and the order of the alphabet,
                return true if and only if the given words are sorted lexicographically in this alien language.

        Example:
            Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
            Output: true
            Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.""";

    public VerifyingAlienDictionary(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, SIZE + 1);
        this.words = new String[size];

        StringBuilder builder;
        for (int i = 0; i < size; i++) {
            builder = new StringBuilder();
            var len = random.nextInt(1, LEN + 1);
            for (int j = 0; j < len; j++) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
            words[i] = builder.toString();
        }

        List<Character> letters = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) letters.add((char) ('a' + i));
        Collections.shuffle(letters);
        this.order = letters.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());

        log.info("Words: {}", Arrays.toString(words));
        log.info("Order: '{}'", order);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 618 ms
    @Override
    protected Boolean original() {
        var original = new Original(words, order);
        return original.process();
    }

    // time = 607 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(words, order);
        return practice.process();
    }

    // time = 606 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(words, order);
        return solution.process();
    }
}
