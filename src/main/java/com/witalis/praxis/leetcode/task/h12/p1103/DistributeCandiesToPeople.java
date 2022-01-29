package com.witalis.praxis.leetcode.task.h12.p1103;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1103.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1103,
    description = "Distribute Candies to People",
    difficulty = TaskDifficulty.EASY,
    tags = {MATH, SIMULATION}
)
public class DistributeCandiesToPeople extends LeetCodeTask<int[]> {
    public static final int LEN_CANDIES = (int) Math.pow(10, 9);
    public static final int LEN_PERSONS = 1_000;

    private int candies;
    private int persons;

    public static final String INFORMATION = """

        We distribute some number of candies, to a row of n = num_people people
            in the following way:

        We then give 1 candy to the first person, 2 candies to the second person,
            and so on until we give n candies to the last person.
         
        Then, we go back to the start of the row, giving n + 1 candies to the first person,
            n + 2 candies to the second person, and so on until we give 2 * n candies to the last person.
         
        This process repeats (with us giving one more candy each time, and moving
            to the start of the row after we reach the end) until we run out of candies.
            The last person will receive all of our remaining candies
            (not necessarily one more than the previous gift).
         
        Return an array (of length num_people and sum candies) that represents
            the final distribution of candies.

        Example:
            Input: candies = 10, num_people = 3
            Output: [5,2,3]
            Explanation:
                On the first turn, ans[0] += 1, and the array is [1,0,0].
                On the second turn, ans[1] += 2, and the array is [1,2,0].
                On the third turn, ans[2] += 3, and the array is [1,2,3].
                On the fourth turn, ans[0] += 4, and the final array is [5,2,3].""";

    public DistributeCandiesToPeople(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        var random = ThreadLocalRandom.current();

        this.candies = random.nextInt(1, LEN_CANDIES + 1);
        this.persons = random.nextInt(1, LEN_PERSONS + 1);

        log.info("Number of candies is {}", candies);
        log.info("Number of persons is {}", persons);
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 2218 ms
    @Override
    protected int[] original() {
        var original = new Original(candies, persons);
        return original.process();
    }

    // time = 2250 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(candies, persons);
        return practice.process();
    }

    // time = 2113 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(candies, persons);
        return solution.process();
    }
}
