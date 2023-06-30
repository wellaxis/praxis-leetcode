package com.witalis.praxis.leetcode.task.h20.p1970;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h20.p1970.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1970,
    description = "Last Day Where You Can Still Cross",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, BINARY_SEARCH, DEPTH_FIRST_SEARCH, BREADTH_FIRST_SEARCH, UNION_FIND, MATRIX}
)
public class LastDayWhereYouCanStillCross extends LeetCodeTask<Integer> {
    public static final int LEN = 200;

    private int row;
    private int col;
    private int[][] cells;

    public static final String INFORMATION = """

        Description:
            There is a 1-based binary matrix where 0 represents land and 1 represents water.
                You are given integers row and col representing the number of rows and columns in the matrix, respectively.

            Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water.
                You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the i^th day,
                the cell on the ri^th row and ci^th column (1-based coordinates) will be covered with water (i.e., changed to 1).

            You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells.
                You can start from any cell in the top row and end at any cell in the bottom row.
                You can only travel in the four cardinal directions (left, right, up, and down).

            Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.

        Example:
            Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
            Output: 2
            Explanation: The above image depicts how the matrix changes each day starting from day 0.
                The last day where it is possible to cross from top to bottom is on day 2.""";

    public LastDayWhereYouCanStillCross(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int rows = random.nextInt(2, LEN + 1);
        int cols = random.nextInt(2, LEN + 1);
        List<int[]> items = new ArrayList<>();
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                items.add(new int[] {i, j});
            }
        }
        Collections.shuffle(items);
        this.cells = items.toArray(int[][]::new);

        log.info("Cells [{} x {}]: {}", rows, cols, Arrays.deepToString(cells));
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 1492 ms
    @Override
    protected Integer original() {
        var original = new Original(row, col, cells);
        return original.process();
    }

    // time = 1350 ms
    @Override
    protected Integer practice() {
        var practice = new Practice(row, col, cells);
        return practice.process();
    }

    // time = 894 ms
    @Override
    protected Integer solution() {
        var solution = new Solution(row, col, cells);
        return solution.process();
    }
}
