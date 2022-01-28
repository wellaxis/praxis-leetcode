package com.witalis.praxis.leetcode.task.h1.p71;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h1.p71.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 71,
    description = "Simplify Path",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {STRING, STACK}
)
public class SimplifyPath extends LeetCodeTask<String> {
    public static final String DEFAULT = "/a//./b/..//..////../c/.../luck/dd";
    private String path;

    public static final String INFORMATION = """

        Given a string path, which is an absolute path (starting with a slash '/')
            to a file or directory in a Unix-style file system,
            convert it to the simplified canonical path.

        In a Unix-style file system,
            a period '.' refers to the current directory,
            a double period '..' refers to the directory up a level,
            and any multiple consecutive slashes (i.e. '//')
            are treated as a single slash '/'.
            For this problem, any other format of periods such as '...'
            are treated as file/directory names.

        The canonical path should have the following format:
        * The path starts with a single slash '/'.
        * Any two directories are separated by a single slash '/'.
        * The path does not end with a trailing '/'.
        * The path only contains the directories on the path
          from the root directory to the target file or directory
          (i.e., no period '.' or double period '..')

        Return the simplified canonical path.

        Example:
            Input: path = "/a/./b/../../c/"
            Output: "/c """;

    public SimplifyPath(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        this.path = DEFAULT;

        log.info("Path is '{}'", path);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 947 ms
    @Override
    protected String original() {
        var original = new Original(path);
        return original.process();
    }

    // time = 983 ms
    @Override
    protected String practice() {
        var practice = new Practice(path);
        return practice.process();
    }

    // time = 726 ms
    @Override
    protected String solution() {
        var solution = new Solution(path);
        return solution.process();
    }
}
