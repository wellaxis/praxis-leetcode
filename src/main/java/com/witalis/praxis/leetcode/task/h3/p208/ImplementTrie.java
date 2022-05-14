package com.witalis.praxis.leetcode.task.h3.p208;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p208.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 208,
    description = "Implement Trie (Prefix Tree)",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, STRING, DESIGN, TRIE}
)
public class ImplementTrie extends LeetCodeTask<List<Boolean>> {
    public static final int LEN = 20;
    public static final int SIZE = 30_000;
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public static final String INFORMATION = """

        A trie (pronounced as "try") or prefix tree is a tree data structure
            used to efficiently store and retrieve keys in a dataset of strings.
            There are various applications of this data structure, such as autocomplete and spellchecker.

        Implement the Trie class:
            * Trie() Initializes the trie object.
            * void insert(String word) Inserts the string word into the trie.
            * boolean search(String word) Returns true if the string word
                is in the trie (i.e., was inserted before), and false otherwise.
            * boolean startsWith(String prefix) Returns true if there is a previously
                inserted string word that has the prefix prefix, and false otherwise.

        Example:
            Input:
                ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
                [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
            Output:
                [null, null, true, false, true, null, true]
            Explanation:
                Trie trie = new Trie();
                trie.insert("apple");   // return null
                trie.search("apple");   // return true
                trie.search("app");     // return false
                trie.startsWith("app"); // return true
                trie.insert("app");     // return null
                trie.search("app");     // return true""";

    public ImplementTrie(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    @SuppressWarnings("unchecked")
    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, SIZE + 1);

        operations = new ArrayList<>(len);
        operations.add(new AbstractMap.SimpleEntry<>("Trie", null));

        for (int i = 1; i < len; i++) {
            int operation = random.nextInt(0, 3);
            String word = generateWord();
            switch (operation) {
                case 0 -> operations.add(new AbstractMap.SimpleEntry<>("insert", word));
                case 1 -> operations.add(new AbstractMap.SimpleEntry<>("search", word));
                case 2 -> operations.add(new AbstractMap.SimpleEntry<>("startsWith", word));
                default -> throw new IllegalArgumentException("unexpected operation");
            }
        }

        log.info("Trie is {}", operations.toString());
    }

    private String generateWord() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

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

    // time = 10312 ms
    @Override
    protected List<Boolean> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 11104 ms
    @Override
    protected List<Boolean> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 9739 ms
    @Override
    protected List<Boolean> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
