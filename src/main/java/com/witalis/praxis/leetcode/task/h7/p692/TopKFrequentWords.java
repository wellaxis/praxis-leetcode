package com.witalis.praxis.leetcode.task.h7.p692;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h7.p692.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 692,
    description = "Top K Frequent Words",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, TRIE, SORTING, HEAP, BUCKET_SORT, COUNTING}
)
public class TopKFrequentWords extends LeetCodeTask<List<String>> {
    public static final int SIZE = 500;
    public static final int LEN = 10;
    private String[] words;
    private int quantity;

    public static final String INFORMATION = """

        Description:
            Given an array of strings words and an integer k, return the k most frequent strings.

            Return the answer sorted by the frequency from highest to lowest.
                Sort the words with the same frequency by their lexicographical order.

        Example:
            Input: words = ["i","love","leetcode","i","love","coding"], k = 2
            Output: ["i","love"]
            Explanation: "i" and "love" are the two most frequent words.
            Note that "i" comes before "love" due to a lower alphabetical order.""";

    public TopKFrequentWords(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int size = random.nextInt(1, SIZE + 1);
        this.quantity = random.nextInt(1, size);

        List<String> list = new ArrayList<>();

        while (size > 0) {
            int len = random.nextInt(1, LEN + 1);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                builder.append((char) random.nextInt('a', 'z' + 1));
            }
            int qty = random.nextInt(1, LEN + 1);
            list.addAll(Collections.nCopies(qty, builder.toString()));
            size--;
        }
        Collections.shuffle(list);
        this.words = list.toArray(new String[0]);

        log.info("Words are {}", Arrays.toString(words));
        log.info("Quantity is {}", quantity);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3768 ms
    @Override
    protected List<String> original() {
        var original = new Original(words.clone(), quantity);
        return original.process();
    }

    // time = 2775 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(words.clone(), quantity);
        return practice.process();
    }

    // time = 1709 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(words.clone(), quantity);
        return solution.process();
    }
}
