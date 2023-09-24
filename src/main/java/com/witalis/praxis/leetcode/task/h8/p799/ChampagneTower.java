package com.witalis.praxis.leetcode.task.h8.p799;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h8.p799.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 799,
    description = "Champagne Tower",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {DYNAMIC_PROGRAMMING}
)
public class ChampagneTower extends LeetCodeTask<Double> {
    public static final int ROW = 100;
    public static final int GLASS = 100;
    public static final int VALUE = 1_000_000;

    private int poured;
    private int row;
    private int glass;

    public static final String INFORMATION = """

        Description:
            We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses,
                and so on until the 100th row. Each glass holds one cup of champagne.

            Then, some champagne is poured into the first glass at the top. When the topmost glass is full,
                any excess liquid poured will fall equally to the glass immediately to the left and right of it.
                When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.
                (A glass at the bottom row has its excess champagne fall on the floor.)

            Now after pouring some non-negative integer cups of champagne,
                return how full the j^th glass in the i^th row is (both i and j are 0-indexed.)

            For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.        Example:
            Input: poured = 2, query_row = 1, query_glass = 1
            Output: 0.50000
            Explanation: We poured 2 cups of champagne to the top glass of the tower (which is indexed as (0, 0)).
                There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1)
                will share the excess liquid equally, and each will get half cup of champagne.""";

    public ChampagneTower(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        this.poured = random.nextInt(0, VALUE + 1);
        this.row = random.nextInt(0, ROW + 1);
        this.glass = random.nextInt(0, GLASS + 1);

        log.info("Poured: {}", poured);
        log.info("Row 'i': {}", row);
        log.info("Glass 'j': {}", glass);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 885 ms
    @Override
    protected Double original() {
        var original = new Original(poured, row, glass);
        return original.process();
    }

    // time = 782 ms
    @Override
    protected Double practice() {
        var practice = new Practice(poured, row, glass);
        return practice.process();
    }

    // time = 639 ms
    @Override
    protected Double solution() {
        var solution = new Solution(poured, row, glass);
        return solution.process();
    }
}
