package com.witalis.praxis.leetcode.task.h24.p2353.option;

import com.witalis.praxis.leetcode.task.h24.p2353.content.IFoodRatingSystem;
import com.witalis.praxis.leetcode.task.h24.p2353.content.FoodRatingSystemHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * ID: 2353
 * Name: Design a Food Rating System
 * URL: <a href="https://leetcode.com/problems/design-a-food-rating-system/">Design a Food Rating System</a>
 * Note: try to find the better solution (without timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Practice {
    private List<AbstractMap.SimpleEntry<String, Object[]>> operations;

    record Food(String name, String cuisine, int rating) {}

    public class FoodRatings implements IFoodRatingSystem {
        private static final Comparator<Food> byRatingAndName = Comparator.comparing(Food::rating).reversed().thenComparing(Food::name);

        private final Map<String, String> cuisineMap;
        private final Map<String, Integer> ratingMap;
        private final Map<String, Queue<Food>> menu;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.cuisineMap = new HashMap<>();
            this.ratingMap = new HashMap<>();
            this.menu = new HashMap<>();

            initialize(foods, cuisines, ratings);
        }

        private void initialize(String[] foods, String[] cuisines, int[] ratings) {
            final int n = foods.length;

            for (int i = 0; i < n; ++i) {
                final Food food = new Food(foods[i], cuisines[i], ratings[i]);

                cuisineMap.put(foods[i], cuisines[i]);
                ratingMap.put(foods[i], ratings[i]);
                menu.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(byRatingAndName)).add(food);
            }
        }

        @Override
        public void changeRating(String food, int newRating) {
            ratingMap.put(food, newRating);
            String cuisine = cuisineMap.get(food);
            menu.get(cuisine).add(new Food(food, cuisine, newRating));
        }

        @Override
        public String highestRated(String cuisine) {
            var heap = menu.get(cuisine);
            if (heap == null) return "";

            Food food = heap.peek();
            if (food == null) return "";

            while (ratingMap.get(food.name()) != food.rating()) {
                menu.get(cuisine).poll();
                food = menu.get(cuisine).peek();
            }

            return food.name();
        }
    }

    public List<String> process() {
        Object[] data = operations.get(0).getValue();
        return FoodRatingSystemHandler.process(operations, new FoodRatings((String[]) data[0], (String[]) data[1], (int[]) data[2]));
    }
}
