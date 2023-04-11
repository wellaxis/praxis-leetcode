# [LeetCode][leetcode] task # 2390: [Removing Stars From a String][task]

Description
-----------

> You are given a string `s`, which contains stars `*`.
> 
> In one operation, you can:
> * Choose a star in `s`.
> * Remove the closest **non-star** character to its **left**, as well as remove the star itself.
>
> Return _the string after **all** stars have been removed_.
> 
> **Note:**
> * The input will be generated such that the operation is always possible.
> * It can be shown that the resulting string will always be unique.

Example
-------

```sh
Input: s = "leet**cod*e"
Output: "lecoe"
Explanation: Performing the removals from left to right:
- The closest character to the 1st star is 't' in "leet**cod*e". s becomes "lee*cod*e".
- The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes "lecod*e".
- The closest character to the 3rd star is 'd' in "lecod*e". s becomes "lecoe".
There are no more stars, so we return "lecoe".
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 2390 | [Removing Stars From a String][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/removing-stars-from-a-string/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h24/p2390/option/Practice.java>
