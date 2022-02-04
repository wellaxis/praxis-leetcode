package com.witalis.praxis.leetcode.task.h2.p193.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

/**
 * ID: 193
 * Name: Valid Phone Numbers
 * URL: https://leetcode.com/problems/valid-phone-numbers/
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private static String regex = "^([0-9]{3}-|\\([0-9]{3}\\) )[0-9]{3}-[0-9]{4}$";
    private File file;

    public String process() {
        log.info("SHELL: {}", readValidPhoneNumbers());
        return readValidPhoneNumbers(file);
    }

    public String readValidPhoneNumbers() {
        return "sed -n -r '/^([0-9]{3}-|\\([0-9]{3}\\) )[0-9]{3}-[0-9]{4}$/p' file.txt";
    }

    public String readValidPhoneNumbers(File file) {
        if (file == null) return "";

        StringBuilder validPhoneNumbers = new StringBuilder("\n");

        try (
            Stream<String> stream = Files.lines(file.toPath())
        ) {
            stream.filter(
                line -> line.matches(regex)
            ).forEach(
                line -> validPhoneNumbers.append(line).append('\n')
            );
        } catch (IOException ioe) {
            log.error("Read 10th line, NIO error: {}", ioe.getMessage());
        }

        if (!validPhoneNumbers.isEmpty()) {
            validPhoneNumbers.deleteCharAt(validPhoneNumbers.length() - 1);
        }

        return validPhoneNumbers.toString();
    }
}
