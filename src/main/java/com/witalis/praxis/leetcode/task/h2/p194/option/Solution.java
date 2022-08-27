package com.witalis.praxis.leetcode.task.h2.p194.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * ID: 194
 * Name: Transpose File
 * URL: <a href="https://leetcode.com/problems/transpose-file/">Transpose File</a>
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private File file;

    public String process() {
        transposeFile(file);
        return transposeFile();
    }

    public String transposeFile() {
        return
            """
            cat file.txt | awk -F" " '{for (f = 1; f <= NF; f++) str[f] = str[f] FS $f} END {for (f = 1; f <= NF; f++) print str[f]}' | sed 's/^ //g'
            """;
    }

    public String transposeFile(File file) {
        if (file == null) return "";

        StringBuilder transpose = new StringBuilder("\\n");

        String[][] content = new String[0][0];
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            if (lines.isEmpty()) return "";
            int columnsLen = lines.get(0).split(" ").length;
            content = new String[lines.size()][columnsLen];
            for (int line = 0; line < lines.size(); line++) {
                String[] columns = lines.get(line).split(" ");
                System.arraycopy(columns, 0, content[line], 0, columnsLen);
            }
        } catch (IOException ioe) {
            log.error("Calculate word frequency, IO error: {}", ioe.getMessage());
        }

        for (int column = 0; column < content[0].length; column++) {
            for (String[] strings : content) {
                transpose.append(strings[column]).append(' ');
            }
            transpose.append('\n');
        }

        return transpose.toString();
    }
}
