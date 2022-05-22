package com.witalis.praxis.leetcode.task.h3.p211;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h3.p211.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 211,
    description = "Design Add and Search Words Data Structure",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, DEPTH_FIRST_SEARCH, DESIGN, TRIE}
)
public class DesignAddAndSearchWordsDataStructure extends LeetCodeTask<List<Boolean>> {
    public static final int LEN = 25;
    public static final int SIZE = 10_000;
    private List<AbstractMap.SimpleEntry<String, String>> operations;

    public static final String INFORMATION = """

        Design a data structure that supports adding new words and finding
            if a string matches any previously added string.

        Implement the WordDictionary class:
            * WordDictionary() Initializes the object.
            * void addWord(word) Adds word to the data structure, it can be matched later.
            * bool search(word) Returns true if there is any string in the data structure
                that matches word or false otherwise.
                word may contain dots '.' where dots can be matched with any letter.

        Example:
            Input:
                ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
                [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
            Output:
                [null,null,null,null,false,true,true,true]
            Explanation:
                WordDictionary wordDictionary = new WordDictionary();
                wordDictionary.addWord("bad");
                wordDictionary.addWord("dad");
                wordDictionary.addWord("mad");
                wordDictionary.search("pad"); // return false
                wordDictionary.search("bad"); // return true
                wordDictionary.search(".ad"); // return true
                wordDictionary.search("b.."); // return true""";

    public DesignAddAndSearchWordsDataStructure(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    @SuppressWarnings("unchecked")
    private void initialization() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, SIZE + 1);

        operations = new ArrayList<>(len);
        operations.add(new AbstractMap.SimpleEntry<>("WordDictionary", null));

        for (int i = 1; i < len; i++) {
            int operation = random.nextInt(0, 2);
            switch (operation) {
                case 0 -> operations.add(new AbstractMap.SimpleEntry<>("addWord", generateWord('G')));
                case 1 -> operations.add(new AbstractMap.SimpleEntry<>("search", generateWord('S')));
                default -> throw new IllegalArgumentException("unexpected operation");
            }
        }

        log.info("Trie is {}", operations.toString());
    }

    private String generateWord(char mode) {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

        int dots = 0;
        var builder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
            if (mode == 'S' && dots < 3) {
                int dot = random.nextInt(0, 4);
                if (dot == 0) {
                    builder.append(".");
                    dots++;
                    i++;
                }
            }
        }

        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3743 ms
    @Override
    protected List<Boolean> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 3134 ms
    @Override
    protected List<Boolean> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 2435 ms
    @Override
    protected List<Boolean> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
