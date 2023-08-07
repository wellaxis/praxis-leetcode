package com.witalis.praxis.leetcode.task.h2.p126;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p126.option.Original;
import com.witalis.praxis.leetcode.task.h2.p126.option.Practice;
import com.witalis.praxis.leetcode.task.h2.p126.option.Solution;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 126,
    description = "Word Ladder II",
    difficulty = TaskDifficulty.HARD,
    tags = {STRING, HASH_TABLE, BACKTRACKING, BREADTH_FIRST_SEARCH}
)
public class WordLadderII extends LeetCodeTask<List<List<String>>> {
    public static final int LEN = 5;
    public static final int SIZE = 500;

    private String beginWord;
    private String endWord;
    private List<String> wordList;

    public static final String INFORMATION = """

        Description:
            A transformation sequence from word beginWord to word endWord using a dictionary wordList
                is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
                * Every adjacent pair of words differs by a single letter.
                * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
                * sk == endWord

            Given two words, beginWord and endWord, and a dictionary wordList,
                return all the shortest transformation sequences from beginWord to endWord,
                or an empty list if no such sequence exists.
                Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

        Example:
            Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
            Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
            Explanation: There are 2 shortest transformation sequences:
                "hit" -> "hot" -> "dot" -> "dog" -> "cog"
                "hit" -> "hot" -> "lot" -> "log" -> "cog" """;

    public WordLadderII(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        int size = random.nextInt(1, SIZE + 1);

        this.beginWord = generate(len);
        this.endWord = generate(len);

        Set<String> words = new HashSet<>();
        for (int i = 0; i < size; i++) {
            words.add(generate(len));
        }
        this.wordList = new ArrayList<>(words);

        log.info("Begin word: '{}'", beginWord);
        log.info("End word: '{}'", endWord);
        log.info("Word list: {}", wordList);
    }

    private static String generate(int len) {
        final var random = ThreadLocalRandom.current();

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

    // time = 4565 ms
    @Override
    protected List<List<String>> original() {
        var original = new Original(beginWord, endWord, wordList);
        return original.process();
    }

    // time = 3858 ms
    @Override
    protected List<List<String>> practice() {
        var practice = new Practice(beginWord, endWord, wordList);
        return practice.process();
    }

    // time = 879 ms
    @Override
    protected List<List<String>> solution() {
        var solution = new Solution(beginWord, endWord, wordList);
        return solution.process();
    }
}
