package com.witalis.praxis.leetcode.task.h2.p195;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p195.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@Slf4j
@LeetCode(
    id = 195,
    description = "Tenth Line",
    difficulty = TaskDifficulty.EASY,
    tags = {SHELL}
)
public class TenthLine extends LeetCodeTask<String> {
    public static final String FILE_PATH = "src/main/java/com/witalis/praxis/leetcode/task/h2/p195/content";
    public static final String FILE_NAME = "file.txt";
    public static final int MAX_LINES = 2_000;
    private File file;
    private int line;

    public static final String INFORMATION = """

        Given a text file file.txt, print just the 10th line of the file.

        Example:
            Assume that file.txt has the following content:
                Line 1
                Line 2
                Line 3
                Line 4
                Line 5
                Line 6
                Line 7
                Line 8
                Line 9
                Line 10
            Your script should output the tenth line, which is:
                Line 10""";

    public TenthLine(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();
        final int lines = random.nextInt(1, MAX_LINES + 1);

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= lines; i++) {
            builder.append("Line ").append(i).append("\n");
        }
        builder.deleteCharAt(builder.length() - 1);

        try {
            Path filePath = Paths.get(FILE_PATH, FILE_NAME);
            Files.delete(filePath);
            Files.createFile(filePath);
            Files.writeString(filePath, builder.toString(), TRUNCATE_EXISTING);

            this.file = filePath.toFile();
            this.line = random.nextInt(1, 2 * lines);

            log.info("File is {}", file.getCanonicalPath());
            log.info("Line is {}", line);
        } catch (IOException ioe) {
            log.error("Input/Output errors: {}", ioe.getMessage());
        }
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 7712 ms
    @Override
    protected String original() {
        var original = new Original(file, line);
        return original.process();
    }

    // time = 9985 ms
    @Override
    protected String practice() {
        var practice = new Practice(file, line);
        return practice.process();
    }

    // time = 4694 ms
    @Override
    protected String solution() {
        var solution = new Solution(file, line);
        return solution.process();
    }
}
