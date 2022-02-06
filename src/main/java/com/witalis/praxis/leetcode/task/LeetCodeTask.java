package com.witalis.praxis.leetcode.task;

import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * Desc: Leetcode tasks handler
 * User: Wellaxis
 * Date: 03.09.2021
 */
@Slf4j
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public abstract class LeetCodeTask<T> implements ITask, EnvironmentAware {
    // constant
    public static final String MSG_CHAR = "-";
    public static final int MSG_LENGTH = 50;
    // variable
    protected int code;
    protected String description;
    protected TaskRevision revision;
    private Environment environment;

    protected LeetCodeTask(int code, String description, TaskRevision revision) {
        super();
        setCode(code);
        setDescription(description);
        setRevision(revision);
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void invoke() {
        log.info(getMarkup());
        describe();
        log.info(getMarkup());
        process();
        log.info(getMarkup());
    }

    private static String getMarkup() {
        return MSG_CHAR.repeat(MSG_LENGTH);
    }

    protected void describe() {
        log.info("Task: {}", code);
        log.info("Note: {}", description);
        log.info("Mode: {}", revision.name());
        log.info("Class: {}", getClass().getSimpleName());
        log.info("Info: {}", getInformation());
    }

    protected abstract String getInformation();

    /**
     * The real test (code writing)
     */
    protected abstract T original();

    /**
     * Try to find the best variant
     */
    protected abstract T practice();

    /**
     * The best solution (external)
     */
    protected abstract T solution();

    /**
     * The real processing of task.
     */
    protected void process() {
        if (getRevision().equals(TaskRevision.B)) {
            benchmark();
        }

        log.info("BEGIN" );
        long before = System.nanoTime();
        // processing
        try {
            var result = switch (getRevision()) {
                case O -> original();
                case P -> practice();
                case S -> solution();
                default -> throw new IllegalStateException(
                    "Unexpected task revision: " + getRevision()
                );
            };
            log.info("RESULT: {}", presentation(result));
        } catch (Exception e) {
            log.error("ERRORS: {}", e.getMessage());
        }
        long after = System.nanoTime();
        log.info("END, time = {} ms", (after - before) / 1000);
    }

    protected void benchmark() {
        metrics();
        System.exit(-1);
    }

    protected void metrics() {
        log.info("BEGIN" );
        long begin = System.nanoTime();
        // processing
        try {
            // original
            {
                long before = System.nanoTime();
                T value = original();
                long after = System.nanoTime();
                log.info("ORIGINAL = {}, time = {}", value, (after - before) / 1000);
            }
            // practice
            {
                long before = System.nanoTime();
                T value = practice();
                long after = System.nanoTime();
                log.info("PRACTICE = {}, time = {}", value, (after - before) / 1000);
            }
            // solution
            {
                long before = System.nanoTime();
                T value = solution();
                long after = System.nanoTime();
                log.info("SOLUTION = {}, time = {}", value, (after - before) / 1000);
            }
        } catch (Exception e) {
            log.error("ERRORS: {}", e.getMessage());
        }
        long end = System.nanoTime();
        log.info("END, time = {} ms", (end - begin) / 1000);
    }

    private String presentation(T result) {
        if (result == null) return "''";

        if (result instanceof int[] array) {
            return Arrays.toString(array);
        } else if (result instanceof int[][] matrix) {
            var builder = new StringBuilder();
            for (int[] array : matrix) {
                builder.append(Arrays.toString(array)).append(' ');
            }
            return builder.toString();
        } else if (result instanceof char[][] matrix) {
            var builder = new StringBuilder();
            for (char[] array : matrix) {
                builder.append(Arrays.toString(array)).append(' ');
            }
            return builder.toString();
        } else {
            return result.toString();
        }
    }
}
