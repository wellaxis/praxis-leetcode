package com.witalis.praxis.leetcode.task.h6.p551;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h6.p551.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 551,
    description = "Student Attendance Record I",
    difficulty = TaskDifficulty.EASY,
    tags = {STRING}
)
public class StudentAttendanceRecordI extends LeetCodeTask<Boolean> {
    public static final int LEN = 1_000;
    private String string;

    public static final String INFORMATION = """

        You are given a string s representing an attendance record for a student
            where each character signifies whether the student was absent, late, or present on that day.
            The record only contains the following three characters:
            * 'A': Absent.
            * 'L': Late.
            * 'P': Present.

        The student is eligible for an attendance award if they meet both of the following criteria:
            * The student was absent ('A') for strictly fewer than 2 days total.
            * The student was never late ('L') for 3 or more consecutive days.

        Return true if the student is eligible for an attendance award, or false otherwise.

        Example:
            Input: s = "PPALLP"
            Output: true
            Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.""";

    public StudentAttendanceRecordI(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        var len = random.nextInt(1, LEN + 1);
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int mode = random.nextInt(0, 10);
            char attendance = switch (mode) {
                case 0, 1, 2, 3, 4, 5 -> 'P';
                case 6, 7, 8 -> 'L';
                case 9 -> 'A';
                default -> ' ';
            };
            builder.append(attendance);
        }
        this.string = builder.toString();

        log.info("String is '{}'", string);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1120 ms
    @Override
    protected Boolean original() {
        var original = new Original(string);
        return original.process();
    }

    // time = 503 ms
    @Override
    protected Boolean practice() {
        var practice = new Practice(string);
        return practice.process();
    }

    // time = 470 ms
    @Override
    protected Boolean solution() {
        var solution = new Solution(string);
        return solution.process();
    }
}
