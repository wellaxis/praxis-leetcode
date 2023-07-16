package com.witalis.praxis.leetcode.task.h12.p1125;

import com.witalis.praxis.leetcode.task.LeetCodeTask;
import com.witalis.praxis.leetcode.task.h12.p1125.option.*;
import com.witalis.praxis.leetcode.utils.LeetCode;
import com.witalis.praxis.leetcode.utils.TaskDifficulty;
import com.witalis.praxis.leetcode.utils.TaskRevision;

import lombok.extern.slf4j.Slf4j;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.witalis.praxis.leetcode.utils.TaskTag.*;

@Slf4j
@LeetCode(
    id = 1125,
    description = "Smallest Sufficient Team",
    difficulty = TaskDifficulty.HARD,
    tags = {ARRAY, DYNAMIC_PROGRAMMING, BIT_MANIPULATION, BITMASK}
)
public class SmallestSufficientTeam extends LeetCodeTask<int[]> {
    public static final int LEN = 16;
    public static final int SIZE = 60;

    private String[] reqSkills;
    private List<List<String>> people;

    public static final String INFORMATION = """

        Description:
            In a project, you have a list of required skills req_skills, and a list of people.
                The ith person people[i] contains a list of skills that the person has.

            Consider a sufficient team: a set of people such that for every required skill in req_skills,
                there is at least one person in the team who has that skill.
                We can represent these teams by the index of each person.
                * For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].

            Return any sufficient team of the smallest possible size, represented by the index of each person.
                You may return the answer in any order.

            It is guaranteed an answer exists.

        Example:
            Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
            Output: [0,2]""";

    public SmallestSufficientTeam(int id, String description, TaskRevision revision) {
        super(id, description, revision);
        initialization();
    }

    private void initialization() {
        final var random = ThreadLocalRandom.current();

        List<String> skills = new ArrayList<>(List.of(
            "Javascript", "Python", "Go", "Java", "Kotlin", "PHP", "C#", "Swift", "R", "Ruby",
            "C++", "Matlab", "TypeScript", "Scala", "SQL", "HTML", "CSS", "NoSQL", "Rust", "Perl"
        ));
        Collections.shuffle(skills);

        int len = random.nextInt(1, LEN + 1);
        this.reqSkills = new String[len];
        for (int i = 0; i < len; i++) {
            reqSkills[i] = skills.get(i).toLowerCase();
        }
        skills = new ArrayList<>(Arrays.stream(reqSkills).toList());

        int size = random.nextInt(1, SIZE + 1);
        this.people = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            len = random.nextInt(0, len + 1);
            Collections.shuffle(skills);
            List<String> personSkills = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                personSkills.add(skills.get(j).toLowerCase());
            }
            people.add(personSkills);
        }

        log.info("Required Skills: {}", Arrays.toString(reqSkills));
        log.info("People: {}", people.toString());
    }

    @Override
    protected String getInformation() {
        return INFORMATION;
    }

    // time = 761 ms
    @Override
    protected int[] original() {
        var original = new Original(reqSkills, people);
        return original.process();
    }

    // time = 758 ms
    @Override
    protected int[] practice() {
        var practice = new Practice(reqSkills, people);
        return practice.process();
    }

    // time = 545 ms
    @Override
    protected int[] solution() {
        var solution = new Solution(reqSkills, people);
        return solution.process();
    }
}
