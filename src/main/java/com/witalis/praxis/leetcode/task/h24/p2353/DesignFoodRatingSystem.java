package com.witalis.praxis.leetcode.task.h24.p2353;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h24.p2353.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 2353,
    description = "Design a Food Rating System",
    difficulty = TaskDifficulty.MEDIUM,
    tags = {HASH_TABLE, DESIGN, HEAP, ORDERED_SET}
)
public class DesignFoodRatingSystem extends LeetCodeTask<List<String>> {
    public static final int LEN = 20_000;
    public static final int VALUE = (int) 1e8;

    private List<AbstractMap.SimpleEntry<String, Object[]>> operations;

    public static final String INFORMATION = """

        Description:
            Design a food rating system that can do the following:
                * Modify the rating of a food item listed in the system.
                * Return the highest-rated food item for a type of cuisine in the system.

            Implement the FoodRatings class:
                * FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system.
                  The food items are described by foods, cuisines and ratings, all of which have a length of n.
                    - foods[i] is the name of the ith food,
                    - cuisines[i] is the type of cuisine of the ith food, and
                    - ratings[i] is the initial rating of the ith food.
                * void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
                * String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine.
                  If there is a tie, return the item with the lexicographically smaller name.

            Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order,
                that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.

        Example:
            Input
                ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
                [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
            Output
                [null, "kimchi", "ramen", null, "sushi", null, "ramen"]
            Explanation
                FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
                foodRatings.highestRated("korean"); // return "kimchi", "kimchi" is the highest rated korean food with a rating of 9.
                foodRatings.highestRated("japanese"); // return "ramen", "ramen" is the highest rated japanese food with a rating of 14.
                foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
                foodRatings.highestRated("japanese"); // return "sushi", "sushi" is the highest rated japanese food with a rating of 16.
                foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
                foodRatings.highestRated("japanese"); // return "ramen", Both "sushi" and "ramen" have a rating of 16. However, "ramen" is lexicographically smaller than "sushi".""";

    public DesignFoodRatingSystem(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        int len = random.nextInt(1, LEN + 1);
        this.operations = new ArrayList<>(len);

        Set<String> countries = new HashSet<>();
        for (String country : Locale.getISOCountries()) {
            Locale locale = new Locale("en", country);
            countries.add(locale.getDisplayCountry().toLowerCase());
        }
        List<String> countryNames = new ArrayList<>(countries);

        String[] foods = new String[len];
        String[] cuisines = new String[len];
        int[] ratings = new int[len];

        for (int i = 0; i < len; i++) {
            foods[i] = generate();
            cuisines[i] = countryNames.get(random.nextInt(0, countryNames.size()));
            ratings[i] = random.nextInt(1, VALUE + 1);
        }

        operations.add(new AbstractMap.SimpleEntry<>("FoodRatings", new Object[] {foods, cuisines, ratings}));
        for (int i = 1; i < len; i++) {
            if (random.nextBoolean()) {
                String cuisine = countryNames.get(random.nextInt(0, countryNames.size()));
                operations.add(new AbstractMap.SimpleEntry<>("highestRated", new Object[] {cuisine}));
            } else {
                String food = foods[random.nextInt(0, len)];
                int newRating = random.nextInt(1, VALUE + 1);
                operations.add(new AbstractMap.SimpleEntry<>("changeRating", new Object[] {food, newRating}));
            }
        }

        log.info("SmallestInfiniteSet is {}", operations);
    }

    private static String generate() {
        final var random = ThreadLocalRandom.current();
        final int MAX_LEN = 10;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < MAX_LEN; i++) {
            builder.append((char) random.nextInt('a', 'z' + 1));
        }
        return builder.toString();
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 5512 ms
    @Override
    protected List<String> original() {
        var original = new Original(operations);
        return original.process();
    }

    // time = 4508 ms
    @Override
    protected List<String> practice() {
        var practice = new Practice(operations);
        return practice.process();
    }

    // time = 6692 ms
    @Override
    protected List<String> solution() {
        var solution = new Solution(operations);
        return solution.process();
    }
}
