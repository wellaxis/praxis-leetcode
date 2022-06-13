package com.witalis.praxis.leetcode.task.h4.p383;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h4.p383.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 383,
    description = "Ransom Note",
    difficulty = TaskDifficulty.EASY,
    tags = {HASH_TABLE, STRING, COUNTING}
)
public class RansomNote extends LeetCodeTask<Boolean> {
    public static final int LEN = 500_000;
    private String ransomNote;
    private String magazine;

    public static final String INFORMATION = """

        Given two strings ransomNote and magazine, return true if ransomNote
            can be constructed by using the letters from magazine and false otherwise.

        Each letter in magazine can only be used once in ransomNote.

        Example:
            Input: ransomNote = "aa", magazine = "aab"
            Output: true""";

    public RansomNote(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.ransomNote = generate();
        this.magazine = generate();

        log.info("Ransom Note is {}", ransomNote);
        log.info("Magazine is {}", magazine);
    }

    private String generate() {
        var random = ThreadLocalRandom.current();
        int len = random.nextInt(1, LEN + 1);

        List<Character> letters = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char letter = (char) random.nextInt('a', 'z' + 1);
            letters.add(letter);
        }

        return letters.stream().map(String::valueOf).collect(Collectors.joining());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 3929 ms
    @Override
    protected Boolean original() {
        var original = new Original(ransomNote, magazine);
        return original.process();
    }

    // time = 3414 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(ransomNote, magazine);
        return practice.process();
    }

    // time = 3203 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(ransomNote, magazine);
        return solution.process();
    }
}
