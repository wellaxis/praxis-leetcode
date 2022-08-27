package com.witalis.praxis.leetcode.task.h2.p194.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * ID: 194
 * Name: Transpose File
 * URL: <a href="https://leetcode.com/problems/transpose-file/">Transpose File</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private File file;

    public String process() {
        transposeFile(file);
        return transposeFile();
    }

    public String transposeFile() {
        return
            """
            seq "$(awk '{print NF}' file.txt | head -n 1)" | xargs -r -I {} sh -c "awk '{print \\${}}' file.txt | xargs -r"
            """;
    }

    public String transposeFile(File file) {
        if (file == null) return "";

        StringBuilder transpose = new StringBuilder('\n');

        Map<Integer, List<String>> content = new LinkedHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file, Charset.defaultCharset()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(" ");
                for (int i = 0; i < columns.length; i++) {
                    String column = columns[i];
                    content.computeIfPresent(i, (key, value) -> { value.add(column); return value; });
                    content.putIfAbsent(i, new LinkedList<>(List.of(column)));
                }
            }
        } catch (IOException ioe) {
            log.error("Transpose file, IO error: {}", ioe.getMessage());
        }

        content.keySet().forEach(
            number -> {
                content.get(number).forEach(
                    value -> transpose.append(value).append(' ')
                );
                transpose.append('\n');
            }
        );

        return transpose.toString();
    }
}
