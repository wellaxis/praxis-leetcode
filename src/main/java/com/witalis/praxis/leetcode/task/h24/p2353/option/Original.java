package com.witalis.praxis.leetcode.task.h24.p2353.option;

import com.witalis.praxis.leetcode.task.h24.p2353.content.IFoodRatingSystem;
import com.witalis.praxis.leetcode.task.h24.p2353.content.FoodRatingSystemHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.AbstractMap;
import java.util.List;

/**
 * ID: 2353
 * Name: Design a Food Rating System
 * URL: <a href="https://leetcode.com/problems/design-a-food-rating-system/">Design a Food Rating System</a>
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Object[]>> operations;

    public class FoodRatingSystem implements IFoodRatingSystem {

        public FoodRatingSystem(String[] foods, String[] cuisines, int[] ratings) {
        }

        @Override
        public void changeRating(String food, int newRating) {
        }

        @Override
        public String highestRated(String cuisine) {
            return "";
        }
    }

    public List<String> process() {
        Object[] data = operations.get(0).getValue();
        return FoodRatingSystemHandler.process(operations, new FoodRatingSystem((String[]) data[0], (String[]) data[1], (int[]) data[2]));
    }
}
