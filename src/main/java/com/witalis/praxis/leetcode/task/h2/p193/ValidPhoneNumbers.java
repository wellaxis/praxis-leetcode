package com.witalis.praxis.leetcode.task.h2.p193;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h2.p193.option.*;
import com.witalis.praxis.leetcode.task.h2.p193.utils.PhoneUtils;
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
    id = 193,
    description = "Valid Phone Numbers",
    difficulty = TaskDifficulty.EASY,
    tags = {SHELL}
)
public class ValidPhoneNumbers extends LeetCodeTask<String> {
    public static final String FILE_PATH = "src/main/java/com/witalis/praxis/leetcode/task/h2/p193/content";
    public static final String FILE_NAME = "file.txt";
    public static final int MAX_LINES = 20;
    private File file;

    public static final String INFORMATION = """

        Given a text file file.txt that contains a list of phone numbers (one per line),
            write a one-liner bash script to print all valid phone numbers.

        You may assume that a valid phone number must appear in one of the following
            two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)

        You may also assume each line in the text file
            must not contain leading or trailing white spaces.

        Example:
            Assume that file.txt has the following content:
                987-123-4567
                123 456 7890
                (123) 456-7890
            Your script should output the following valid phone numbers:
                987-123-4567
                (123) 456-7890""";

    public ValidPhoneNumbers(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        String phoneNumbers = PhoneUtils.generatePhoneNumbers(MAX_LINES);

        try {
            Path filePath = Paths.get(FILE_PATH, FILE_NAME);
            if (filePath.toFile().exists())
                Files.delete(filePath);
            Files.createFile(filePath);
            Files.writeString(filePath, phoneNumbers, TRUNCATE_EXISTING);

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

    // time = 5396 ms
    @Override
    protected String original() {
        var original = new Original(file);
        return original.process();
    }

    // time = 2484 ms
    @Override
    protected String practice() {
        var practice = new Practice(file);
        return practice.process();
    }

    // time = 3704 ms
    @Override
    protected String solution() {
        var solution = new Solution(file);
        return solution.process();
    }
}
