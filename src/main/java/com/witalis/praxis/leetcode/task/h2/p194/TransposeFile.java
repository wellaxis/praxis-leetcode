package com.witalis.praxis.leetcode.task.h2.p194;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p194.option.*;
import com.witalis.praxis.leetcode.task.h2.p194.utils.*;
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
    id = 194,
    description = "Transpose File",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {SHELL}
)
public class TransposeFile extends LeetCodeTask<String> {
    public static final String FILE_PATH = "src/main/java/com/witalis/praxis/leetcode/task/h2/p194/content";
    public static final String FILE_NAME = "file.txt";
    private File file;

    public static final String INFORMATION = """

        Given a text file file.txt, transpose its content.

        You may assume that each row has the same number of columns,
            and each field is separated by the ' ' character.

        Example:
            If file.txt has the following content:
                name age
                alice 21
                ryan 30
            Output the following:
                name alice ryan
                age 21 30""";

    public TransposeFile(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        String content = WordUtils.getContent();

        try {
            Path filePath = Paths.get(FILE_PATH, FILE_NAME);
            if (filePath.toFile().exists()) Files.delete(filePath);
            Files.createFile(filePath);
            Files.writeString(filePath, content, TRUNCATE_EXISTING);

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

    // time = 978 ms
    @Override
    protected String original() {
        var original = new Original(file);
        return original.process();
    }

    // time = 410 ms
    @Override
    protected String practice() {
        var practice = new Practice(file);
        return practice.process();
    }

    // time = 172 ms
    @Override
    protected String solution() {
        var solution = new Solution(file);
        return solution.process();
    }
}
