package com.witalis.praxis.leetcode.task.h2.p195.utils;

/**
 * Desc: Line Utilities
 * User: Wellaxis
 * Date: 04.02.2022
 */
public final class LineUtils {

    private LineUtils() {
        super();
    }

    public static String generateTenthLines(int lines) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= lines; i++) {
            builder.append("Line ").append(i).append("\n");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
