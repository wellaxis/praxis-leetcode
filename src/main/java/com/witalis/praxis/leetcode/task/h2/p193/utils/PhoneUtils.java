package com.witalis.praxis.leetcode.task.h2.p193.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Desc: Phone Utilities
 * User: Wellaxis
 * Date: 04.02.2022
 */
public final class PhoneUtils {
    public static final String FORMAT_1ST = "(xxx) xxx-xxxx";
    public static final String FORMAT_2ND = "xxx-xxx-xxxx";

    private PhoneUtils() {
        super();
    }

    public static String generatePhoneNumbers(int size) {
        StringBuilder builder = new StringBuilder();

        generatePhoneNumberList(size).forEach(
            phoneNumber -> builder.append(phoneNumber).append('\n')
        );

        return builder.toString();
    }

    private static List<String> generatePhoneNumberList(int size) {
        final var random = ThreadLocalRandom.current();

        List<String> phoneNumbers = new ArrayList<>();

        // the 1st format
        int lines = random.nextInt(0, size + 1);
        for (int i = 1; i <= lines; i++) {
            phoneNumbers.add(generatePhoneNumber(FORMAT_1ST));
        }
        // the 2nd format
        lines = random.nextInt(0, size + 1 - lines);
        for (int i = 1; i <= lines; i++) {
            phoneNumbers.add(generatePhoneNumber(FORMAT_2ND));
        }
        // the 3rd format
        lines = size - phoneNumbers.size();
        for (int i = 1; i <= lines; i++) {
            phoneNumbers.add(generatePhoneNumber(null));
        }

        Collections.shuffle(phoneNumbers);

        return phoneNumbers;
    }

    private static String generatePhoneNumber(String format) {
        final var random = ThreadLocalRandom.current();

        StringBuilder builder = new StringBuilder();

        if (format != null) {
            format.chars().forEach(
                c -> {
                    if (c == 'x') {
                        builder.append(random.nextInt(0, 10));
                    } else {
                        builder.append((char) c);
                    }
                }
            );
        } else {
            int counter = 10;
            while (counter != 0) {
                if (random.nextInt(0, 3) % 3 == 0) {
                    builder.append(" ");
                } else {
                    builder.append(random.nextInt(0, 10));
                    counter--;
                }
            }
        }

        return builder.toString().trim();
    }
}
