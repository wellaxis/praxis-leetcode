# [LeetCode][leetcode] task # 299: [Bulls and Cows][task]

Description
-----------

> ou are playing the `Bulls and Cows` game with your friend.
> 
> You write down a secret number and ask your friend to guess what the number is.
> When your friend makes a guess, you provide a hint with the following info:
> * The number of "bulls", which are digits in the guess that are in the correct position.
> * The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position.
> Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
> 
> Given the secret number `secret` and your friend's guess `guess`, return _the hint for your friend's guess_.
> 
> The hint should be formatted as `"xAyB"`, where `x` is the number of bulls and `y` is the number of cows.
> Note that both secret and guess may contain duplicate digits.

Example
-------

```sh
Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"
 _ __
```

Solution
--------

| Task | Solution                   |
|:----:|:---------------------------|
| 299  | [Bulls and Cows][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/bulls-and-cows/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h3/p299/option/Practice.java>
