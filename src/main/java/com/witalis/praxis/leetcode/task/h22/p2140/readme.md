# [LeetCode][leetcode] task # 2140: [Solving Questions With Brainpower][task]

Description
-----------

> You are given a **0-indexed** 2D integer array `questions` where `questions[i] = [points[i], brainpower[i]]`.
> 
> The array describes the questions of an exam, where you have to process the questions **in order**
> (i.e., starting from question `0`) and make a decision whether to **solve** or **skip** each question.
> Solving question `i` will **earn** you `points[i]` points,
> but you will be **unable** to solve each of the next brainpower[i] questions.
> If you skip question `i`, you get to make the decision on the next question.
> 
> For example, given `questions = [[3, 2], [4, 3], [4, 4], [2, 5]]`:
> * If question `0` is solved, you will earn `3` points,
> but you will be unable to solve questions `1` and `2`.
> * If instead, question `0` is skipped and question `1` is solved, you will earn `4` points,
> but you will be unable to solve questions `2` and `3`.
>
> Return _the maximum points you can earn for the exam_.

Example
-------

```sh
Input: questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
Output: 7
Explanation: The maximum points can be earned by solving questions 1 and 4.
- Skip question 0
- Solve question 1: Earn 2 points, will be unable to solve the next 2 questions
- Unable to solve questions 2 and 3
- Solve question 4: Earn 5 points
Total points earned: 2 + 5 = 7. There is no other way to earn 7 or more points.
```

Solution
--------

| Task | Solution                                      |
|:----:|:----------------------------------------------|
| 2140 | [Solving Questions With Brainpower][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/solving-questions-with-brainpower/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h22/p2140/option/Practice.java>
