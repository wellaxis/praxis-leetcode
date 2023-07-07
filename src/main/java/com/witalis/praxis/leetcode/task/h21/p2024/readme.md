# [LeetCode][leetcode] task # 2024: [Maximize the Confusion of an Exam][task]

Description
-----------

> A teacher is writing a test with `n` true/false questions, with `'T'` denoting true and `'F'` denoting false.
> He wants to confuse the students by **maximizing** the number of **consecutive** questions with the **same** answer
> (multiple trues or multiple falses in a row).
> 
> You are given a string `answerKey`, where `answerKey[i]` is the original answer to the `i^th` question.
> In addition, you are given an integer `k`, the maximum number of times you may perform the following operation:
> * Change the answer key for any question to `'T'` or `'F'` (i.e., set `answerKey[i]` to `'T'` or `'F'`).
>
> Return _the **maximum** number of consecutive `'T'`s or `'F'`s in the answer key after performing the operation at most `k` times_.

Example
-------

```sh
Input: answerKey = "TTFTTFTT", k = 1
Output: 5
Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
    Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT". 
    In both cases, there are five consecutive 'T's.
```

Solution
--------

| Task | Solution                                      |
|:----:|:----------------------------------------------|
| 2024 | [Maximize the Confusion of an Exam][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/maximize-the-confusion-of-an-exam/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h21/p2024/option/Practice.java>
