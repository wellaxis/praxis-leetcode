package com.witalis.praxis.leetcode.task.h2.p195.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;

/**
 * ID: 195
 * Name: Tenth Line
 * URL: https://leetcode.com/problems/tenth-line/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private File file;
    private int line;

    public String process() {
        log.info("SHELL: {}", readTenthLine());
        return readTenthLine(file, line);
    }

    public String readTenthLine() {
        return "head -n 10 file.txt | tail -n +10";
    }

    public String readTenthLine(File file, int line) {
        if (file == null) return "";

        StringBuilder builder = new StringBuilder();

        int counter = 1;
        try (
            var fis = new FileInputStream(file);
            var bis = new BufferedInputStream(fis);
        ) {
            int c;
            while ((c = bis.read()) != -1) {
                char ch = (char) c;
                if (ch == '\n') {
                    if (counter == line) {
                        return builder.toString();
                    } else {
                        builder.setLength(0);
                        counter++;
                    }
                } else {
                    builder.append(ch);
                }
            }
        } catch (IOException ioe) {
            log.error("Read 10th line, IO error: {}", ioe.getMessage());
        }

        return "";
    }

    public String readTenthLineReader(File file, int line) {
        if (file == null) return "";

        int counter = 1;
        try (
            BufferedReader br = new BufferedReader(
                new FileReader(file, Charset.defaultCharset())
            )
        ) {
            String content;
            while ((content = br.readLine()) != null) {
                if (counter == line) return content;
                counter++;
            }
        } catch (IOException ioe) {
            log.error("Read 10th line, IO error: {}", ioe.getMessage());
        }

        return "";
    }
}
