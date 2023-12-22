# [LeetCode][leetcode] task # 1422: [Maximum Score After Splitting a String][task]

Description
-----------

> Given a string `s` of zeros and ones, return _the maximum score after splitting the string
> into two **non-empty** substrings (i.e. **left** substring and **right** substring)_.
> 
> The score after splitting a string is the number of **zeros**
> in the **left** substring plus the number of **ones** in the **right** substring.

Example
-------

```sh
Input: s = "011101"
Output: 5 
Explanation: 
    All possible ways of splitting s into two non-empty substrings are:
    left = "0" and right = "11101", score = 1 + 4 = 5 
    left = "01" and right = "1101", score = 1 + 3 = 4 
    left = "011" and right = "101", score = 1 + 2 = 3 
    left = "0111" and right = "01", score = 1 + 1 = 2 
    left = "01110" and right = "1", score = 2 + 1 = 3
```

Solution
--------

| Task | Solution                                           |
|:----:|:---------------------------------------------------|
| 1422 | [Maximum Score After Splitting a String][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/maximum-score-after-splitting-a-string/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h15/p1422/option/Practice.java>
