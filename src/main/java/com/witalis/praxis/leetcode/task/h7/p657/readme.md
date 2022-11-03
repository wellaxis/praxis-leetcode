# [LeetCode][leetcode] task # 657: [Robot Return to Origin][task]

Description
-----------

> There is a robot starting at the position `(0, 0)`, the origin, on a 2D plane.
> Given a sequence of its moves, judge if this robot **ends up at** `(0, 0)` after it completes its moves.
> 
> You are given a string `moves` that represents the move sequence of the robot
> where `moves[i]` represents its `i^th` move.
> Valid moves are `'R'` (right), `'L'` (left), `'U'` (up), and `'D'` (down).
> 
> Return _`true` if the robot returns to the origin after it finishes all of its moves, or `false` otherwise_.
> 
> **Note**: The way that the robot is "facing" is irrelevant.
> 'R' will always make the robot move to the right once, 'L' will always make it move left, etc.
> Also, assume that the magnitude of the robot's movement is the same for each move.

 Example
-------

```sh
Input: moves = "UD"
Output: true
Explanation: The robot moves up once, and then down once.
    All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
```

Solution
--------

| Task | Solution                           |
|:----:|:-----------------------------------|
| 657  | [Robot Return to Origin][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/robot-return-to-origin/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h7/p657/option/Practice.java>
