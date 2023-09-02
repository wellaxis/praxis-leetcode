# [LeetCode][leetcode] task # 2707: [Extra Characters in a String][task]

Description
-----------

> You are given a **0-indexed** string `s` and a dictionary of words `dictionary`.
> You have to break `s` into one or more **non-overlapping** substrings such that each substring is present in dictionary.
> There may be some **extra characters** in `s` which are not present in any of the substrings.
> 
> Return _the **minimum** number of extra characters left over if you break up `s` optimally_.

Example
-------

```sh
Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8.
    There is only 1 unused character (at index 4), so we return 1.
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 2707 | [Extra Characters in a String][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/extra-characters-in-a-string/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h28/p2707/option/Practice.java>
