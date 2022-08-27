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
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private File file;

    public String process() {
        transposeFile(file);
        return transposeFile();
    }

    public String transposeFile() {
        return
            """
            for i in $(seq 1 $(head -n1 file.txt | wc -w)); do echo $(cut -d' ' -f$i file.txt); done
            """;
    }

    public String transposeFile(File file) {
        if (file == null) return "";

        StringBuilder transpose = new StringBuilder('\n');

        String[][] content = new String[0][0];
        try {
            List<String> lines = Files.readAllLines(file.toPath());
            if (lines.isEmpty()) return "";
            int columnsLen = lines.get(0).split(" ").length;
            content = new String[lines.size()][columnsLen];
            for (int line = 0; line < lines.size(); line++) {
                String[] columns = lines.get(line).split(" ");
                for (int column = 0; column < columnsLen; column++) {
                    content[line][column] = columns[column];
                }
            }
        } catch (IOException ioe) {
            log.error("Transpose file, IO error: {}", ioe.getMessage());
        }

        for (int column = 0; column < content[0].length; column++) {
            for (int line = 0; line < content.length; line++) {
                transpose.append(content[line][column]).append(' ');
            }
            transpose.append('\n');
        }

        return transpose.toString();
    }
}
