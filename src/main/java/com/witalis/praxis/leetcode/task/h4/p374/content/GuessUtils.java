package com.witalis.praxis.leetcode.task.h4.p374.content;

/**
 * Desc: Guess utilities
 * User: Wellaxis
 * Date: 5/17/2022
 */
public final class GuessUtils {
    private static int pick;

    private GuessUtils() {
        super();
    }

    public static void setPick(int pick) {
        GuessUtils.pick = pick;
    }

    /**
     * A pre-defined API, which returns three possible results:
     * -1: Your guess is higher than the number I picked (i.e. num > pick).
     * 1: Your guess is lower than the number I picked (i.e. num < pick).
     * 0: your guess is equal to the number I picked (i.e. num == pick).
     *
     * @param num the number for guess comparison
     * @return 0, -1, 1 if guess is equals, higher or lower than the number
     */
    public static int guess(int num) {
        return Integer.compare(pick, num);
    }
}
