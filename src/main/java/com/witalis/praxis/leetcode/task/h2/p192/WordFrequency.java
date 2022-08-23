package com.witalis.praxis.leetcode.task.h2.p192;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p192.option.*;
import com.witalis.praxis.leetcode.task.h2.p192.utils.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@Slf4j
@LeetCode(
    id = 192,
    description = "Word Frequency",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {SHELL}
)
public class WordFrequency extends LeetCodeTask<String> {
    public static final String FILE_PATH = "src/main/java/com/witalis/praxis/leetcode/task/h2/p192/content";
    public static final String FILE_NAME = "words.txt";
    private File file;

    public static final String INFORMATION = """

        Write a bash script to calculate the frequency of each word in a text file words.txt.

        For simplicity sake, you may assume:
            * words.txt contains only lowercase characters and space ' ' characters.
            * Each word must consist of lowercase characters only.
            * Words are separated by one or more whitespace characters.

        Example:
            Assume that words.txt has the following content:
                the day is sunny the the
                the sunny is is
            Your script should output the following, sorted by descending frequency:
                the 4
                is 3
                sunny 2
                day 1""";

    public WordFrequency(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        String words = WordUtils.getContent();

        try {
            Path filePath = Paths.get(FILE_PATH, FILE_NAME);
            if (filePath.toFile().exists()) Files.delete(filePath);
            Files.createFile(filePath);
            Files.writeString(filePath, words, TRUNCATE_EXISTING);

            this.file = filePath.toFile();

            log.info("File is {}", file.getCanonicalPath());
        } catch (IOException ioe) {
            log.error("Input/Output errors: {}", ioe.getMessage());
        }
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 151 ms
    @Override
    protected String original() {
        var original = new Original(file);
        return original.process();
    }

    // time = 143 ms
    @Override
    protected String practice() {
        var practice = new Practice(file);
        return practice.process();
    }

    // time = 113 ms
    @Override
    protected String solution() {
        var solution = new Solution(file);
        return solution.process();
    }
}
