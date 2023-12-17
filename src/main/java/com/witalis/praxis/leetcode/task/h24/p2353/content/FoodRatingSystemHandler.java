package com.witalis.praxis.leetcode.task.h24.p2353.content;

import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Desc: Food rating system operations handler
 * User: Wellaxis
 * Date: 17/12/2023
 */
@Slf4j
public final class FoodRatingSystemHandler {

    private FoodRatingSystemHandler() {
        super();
    }

    public static List<String> process(
        List<AbstractMap.SimpleEntry<String, Object[]>> operations,
        IFoodRatingSystem foodRatingSystem
    ) {
        List<String> results = new ArrayList<>();

        IFoodRatingSystem handlingFoodRatingSystem = null;

        for (AbstractMap.SimpleEntry<String, Object[]> operation: operations) {
            var name = operation.getKey();
            var value = operation.getValue();
            switch (name) {
                case "FoodRatings" -> {
                    assert handlingFoodRatingSystem == null;
                    handlingFoodRatingSystem = foodRatingSystem;
                    results.add(null);
                }
                case "highestRated" -> {
                    assert handlingFoodRatingSystem != null;
                    String cuisine = (String) value[0];
                    String food = handlingFoodRatingSystem.highestRated(cuisine);
                    results.add(food);
                }
                case "changeRating" -> {
                    assert handlingFoodRatingSystem != null;
                    String food = (String) value[0];
                    int newRating = (Integer) value[1];
                    handlingFoodRatingSystem.changeRating(food, newRating);
                    results.add("");
                }
                default -> throw new UnsupportedOperationException(
                    "Unrecognisable operation has been detected: " + operation
                );
            }
        }

        return results;
    }
}
