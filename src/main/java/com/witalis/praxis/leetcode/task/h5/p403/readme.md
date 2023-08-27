# [LeetCode][leetcode] task # 403: [Frog Jump][task]

Description
-----------

> A frog is crossing a river. The river is divided into some number of units, and at each unit,
> there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
> 
> Given a list of `stones`' positions (in units) in sorted **ascending order**,
> determine if the frog can cross the river by landing on the last stone.
> Initially, the frog is on the first stone and assumes the first jump must be `1` unit.
> 
> If the frog's last jump was `k` units, its next jump must be either `k - 1`, `k`, or `k + 1` units.
> The frog can only jump in the forward direction.

 Example
-------

```sh
Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone,
    then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone,
    then 4 units to the 7th stone, and 5 units to the 8th stone.
```

Solution
--------

| Task | Solution              |
|:----:|:----------------------|
| 403  | [Frog Jump][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/frog-jump/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h5/p403/option/Practice.java>
