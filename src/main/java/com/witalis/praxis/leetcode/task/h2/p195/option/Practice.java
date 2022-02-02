package com.witalis.praxis.leetcode.task.h2.p195.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

/**
 * ID: 195
 * Name: Tenth Line
 * URL: https://leetcode.com/problems/tenth-line/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private File file;
    private int line;

    public String process() {
        log.info("SHELL: {}", readTenthLine());
        return readTenthLine(file, line);
    }

    public String readTenthLine() {
        return "cat file.txt | awk 'NR==10'";
    }

    public String readTenthLine(File file, int line) {
        if (file == null) return "";

        StringBuilder builder = new StringBuilder();

        int counter = 1;
        try (
            SeekableByteChannel channel = Files.newByteChannel(file.toPath(), StandardOpenOption.READ)
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(16);

            int portion;
            while ((portion = channel.read(buffer)) != -1) {
                buffer.rewind();
                for (int i = 0; i < portion; i++) {
                    char ch = (char) buffer.get();
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
            }
        } catch (IOException ioe) {
            log.error("Read 10th line, NIO error: {}", ioe.getMessage());
        }

        return "";
    }
}
