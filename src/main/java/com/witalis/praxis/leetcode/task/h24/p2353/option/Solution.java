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
 * Note: the best found solution (external programming)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    private List<AbstractMap.SimpleEntry<String, Object[]>> operations;

    public class FoodRatings implements IFoodRatingSystem {
        Map<String, PriorityQueue<Food>> cuisineToFood = new HashMap<>();
        Map<String, Food> foodMap = new HashMap<>();

        class Food {
            String food;
            String cuisine;
            int rating;

            Food(String food, String cuisine, int rating) {
                this.food = food;
                this.cuisine = cuisine;
                this.rating = rating;
            }
        }

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rating = ratings[i];

                if (!cuisineToFood.containsKey(cuisine))
                    cuisineToFood.put(cuisine, new PriorityQueue<>((p1, p2) -> {
                        if (p1.rating == p2.rating) return p1.food.compareTo(p2.food);
                        return p2.rating - p1.rating;
                    }));

                Food aFood = new Food(food, cuisine, rating);

                cuisineToFood.get(cuisine).add(aFood);
                foodMap.put(food, aFood);
            }
        }

        @Override
        public void changeRating(String food, int newRating) {
            Food food1 = foodMap.get(food);
            Food food2 = new Food(food, food1.cuisine, newRating);

            food1.food = "";
            foodMap.put(food, food2);
            cuisineToFood.get(food2.cuisine).add(food2);
        }

        @Override
        public String highestRated(String cuisine) {
            String food = cuisineToFood.get(cuisine).peek().food;
            while (food.equals("")) {
                cuisineToFood.get(cuisine).poll();
                food = cuisineToFood.get(cuisine).peek().food;
            }
            return food;
        }
    }

    public List<String> process() {
        Object[] data = operations.get(0).getValue();
        return FoodRatingSystemHandler.process(operations, new FoodRatings((String[]) data[0], (String[]) data[1], (int[]) data[2]));
    }
}
