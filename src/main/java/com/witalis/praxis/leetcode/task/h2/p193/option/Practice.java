package com.witalis.praxis.leetcode.task.h2.p193.option;

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
 * ID: 193
 * Name: Valid Phone Numbers
 * URL: https://leetcode.com/problems/valid-phone-numbers/
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private static String format1st = "^\\([\\d]{3}\\) [\\d]{3}-[\\d]{4}$";
    private static String format2nd = "^[\\d]{3}-[\\d]{3}-[\\d]{4}$";
    private File file;

    public String process() {
        log.info("SHELL: {}", readValidPhoneNumbers());
        return readValidPhoneNumbers(file);
    }

    public String readValidPhoneNumbers() {
        return "cat file.txt | grep -P '(^\\(\\d{3}\\) \\d{3}-\\d{4}$)|(^\\d{3}-\\d{3}-\\d{4}$)'";
    }

    public String readValidPhoneNumbers(File file) {
        if (file == null) return "";

        StringBuilder validPhoneNumbers = new StringBuilder("\n");
        StringBuilder builder = new StringBuilder();

        try (
            SeekableByteChannel channel = Files.newByteChannel(file.toPath(), StandardOpenOption.READ)
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(64);

            int portion;
            while ((portion = channel.read(buffer)) != -1) {
                buffer.rewind();
                for (int i = 0; i < portion; i++) {
                    char ch = (char) buffer.get();
                    if (ch == '\n') {
                        String line = builder.toString();
                        if (line.matches(format1st) || line.matches(format2nd)) {
                            validPhoneNumbers.append(line).append('\n');
                        }
                        builder.setLength(0);
                    } else {
                        builder.append(ch);
                    }
                }
            }
        } catch (IOException ioe) {
            log.error("Read valid phone numbers, NIO error: {}", ioe.getMessage());
        }

        if (!validPhoneNumbers.isEmpty()) {
            validPhoneNumbers.deleteCharAt(validPhoneNumbers.length() - 1);
        }

        return validPhoneNumbers.toString();
    }
}
