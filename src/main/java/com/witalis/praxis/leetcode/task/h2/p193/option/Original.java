package com.witalis.praxis.leetcode.task.h2.p193.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Pattern;

/**
 * ID: 193
 * Name: Valid Phone Numbers
 * URL: https://leetcode.com/problems/valid-phone-numbers/
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private static Pattern format1st = Pattern.compile("^\\([\\d]{3}\\) [\\d]{3}-[\\d]{4}(\\r\\n|\\n|$)");
    private static Pattern format2nd = Pattern.compile("^[\\d]{3}-[\\d]{3}-[\\d]{4}(\\r\\n|\\n|$)");
    private File file;

    public String process() {
        log.info("SHELL: {}", readValidPhoneNumbers());
        return readValidPhoneNumbers(file);
    }

    public String readValidPhoneNumbers() {
        return "awk '/^([0-9]{3}-|\\([0-9]{3}\\) )[0-9]{3}-[0-9]{4}$/' file.txt";
    }

    public String readValidPhoneNumbers(File file) {
        if (file == null) return "";

        StringBuilder validPhoneNumbers = new StringBuilder("\n");

        try (
            BufferedReader br = new BufferedReader(
                new FileReader(file, Charset.defaultCharset())
            )
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                if (format1st.matcher(line).matches() || format2nd.matcher(line).matches()) {
                    validPhoneNumbers.append(line).append('\n');
                }
            }
        } catch (IOException ioe) {
            log.error("Read valid phone numbers, IO error: {}", ioe.getMessage());
        }

        if (!validPhoneNumbers.isEmpty()) {
            validPhoneNumbers.deleteCharAt(validPhoneNumbers.length() - 1);
        }

        return validPhoneNumbers.toString();
    }
}
