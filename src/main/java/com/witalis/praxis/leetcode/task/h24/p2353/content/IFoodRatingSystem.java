package com.witalis.praxis.leetcode.task.h24.p2353.content;

/**
 * Desc: Food rating system interface.
 * User: Wellaxis
 * Date: 17/12/2023
 */
public interface IFoodRatingSystem {
    void changeRating(String food, int newRating);
    String highestRated(String cuisine);
}
