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
 * Note: the real test solution (code writing with timing)
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Original {
    private List<AbstractMap.SimpleEntry<String, Object[]>> operations;

    record Food(String name, String cuisine, int rating) {}

    public class FoodRatings implements IFoodRatingSystem {
        private static final Comparator<Food> byRatingAndName = Comparator.comparing(Food::rating).reversed().thenComparing(Food::name);

        private final Map<String, Food> foodstuffs;
        private final Map<String, Queue<Food>> menu;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            this.foodstuffs = new HashMap<>();
            this.menu = new HashMap<>();

            initialize(foods, cuisines, ratings);
        }

        private void initialize(String[] foods, String[] cuisines, int[] ratings) {
            final int n = foods.length;
            for (int i = 0; i < n; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                foodstuffs.put(food.name(), food);
                menu.putIfAbsent(cuisines[i], new PriorityQueue<>(byRatingAndName));
                menu.get(cuisines[i]).add(food);
            }
        }

        @Override
        public void changeRating(String food, int newRating) {
            Food original = foodstuffs.get(food);
            String cuisine = original.cuisine();

            var heap = menu.get(cuisine);
            for (Food current : heap) {
                if (current.equals(original)) {
                    heap.remove(current);
                    break;
                }
            }
            Food renewed = new Food(food, cuisine, newRating);
            heap.offer(renewed);

            foodstuffs.put(food, renewed);
        }

        @Override
        public String highestRated(String cuisine) {
            var heap = menu.get(cuisine);

            return heap != null && !heap.isEmpty() ? heap.peek().name() : "";
        }
    }

    public List<String> process() {
        Object[] data = operations.get(0).getValue();
        return FoodRatingSystemHandler.process(operations, new FoodRatings((String[]) data[0], (String[]) data[1], (int[]) data[2]));
    }
}
