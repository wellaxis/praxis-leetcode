# [LeetCode][leetcode] task # 401: [Binary Watch][task]

Description
-----------

> A binary watch has 4 LEDs on the top to represent the hours (0-11),
> and 6 LEDs on the bottom to represent the minutes (0-59).
> Each LED represents a zero or one, with the least significant bit on the right.
> * For example, the below binary watch reads "4:51".

![watch.png](image/watch.png)
 
> Given an integer `turnedOn` which represents the number of LEDs that are currently on (ignoring the PM),
> return _all possible times the watch could represent_. You may return the answer in **any order**.
> 
> The hour must not contain a leading zero.
> * For example, `"01:00"` is not valid. It should be `"1:00"`.
> The minute must be consisted of two digits and may contain a leading zero.
> * For example, `"10:2"` is not valid. It should be `"10:02"`.

 Example
-------

```sh
Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
```

Solution
--------

| Task | Solution                 |
|:----:|:-------------------------|
| 401  | [Binary Watch][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/number-of-segments-in-a-string/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h5/p401/option/Practice.java>
