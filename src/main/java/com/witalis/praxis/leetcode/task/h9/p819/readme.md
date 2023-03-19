# [LeetCode][leetcode] task # 819: [Most Common Word][task]

Description
-----------

> Given a string `paragraph` and a string array of the banned words `banned`,
> return _the most frequent word that is not banned_.
> It is **guaranteed** there is **at least one word** that is not banned, and that the answer is **unique**.
> 
> The words in `paragraph` are **case-insensitive** and the answer should be returned in **lowercase**.

Example
-------

```sh
Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: 
    "hit" occurs 3 times, but it is a banned word.
    "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
    Note that words in the paragraph are not case sensitive,
    that punctuation is ignored (even if adjacent to words, such as "ball,"), 
    and that "hit" isn't the answer even though it occurs more because it is banned.
```

Solution
--------

| Task | Solution                     |
|:----:|:-----------------------------|
| 819  | [Most Common Word][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/most-common-word/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h9/p819/option/Practice.java>
