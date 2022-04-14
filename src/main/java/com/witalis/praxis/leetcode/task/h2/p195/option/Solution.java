package com.witalis.praxis.leetcode.task.h2.p195.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * ID: 195
 * Name: Tenth Line
 * URL: <a href="https://leetcode.com/problems/tenth-line/">Tenth Line</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private File file;
    private int line;

    public String process() {
        log.info("SHELL: {}", readTenthLine());
        return readTenthLine(file, line);
    }

    public String readTenthLine() {
        return "sed -n '10p' file.txt";
    }

    public String readTenthLine(File file, int line) {
        if (file == null) return "";

        try (
            Stream<String> stream = Files.lines(file.toPath())
        ) {
            Optional<String> content = stream.skip(line - 1L).findFirst();
            return content.orElse("");
        } catch (IOException ioe) {
            log.error("Read 10th line, NIO error: {}", ioe.getMessage());
        }

        return "";
    }
}
