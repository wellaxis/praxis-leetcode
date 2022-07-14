# [LeetCode][leetcode] task # 150: [Evaluate Reverse Polish Notation][task]

Description
-----------

> Evaluate the value of an arithmetic expression in **Reverse Polish Notation**.
> 
> Valid operators are `+`, `-`, `*`, and `/`. Each operand may be an integer or another expression.
> 
> **Note** that division between two integers should truncate toward zero.
> 
> It is guaranteed that the given RPN expression is always valid.
> That means the expression would always evaluate to a result,
> and there will not be any division by zero operation.

Example
-------

```sh
Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
```

Solution
--------

| Task | Solution                                     |
|:----:|:---------------------------------------------|
| 150  | [Evaluate Reverse Polish Notation][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/evaluate-reverse-polish-notation/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p150/option/Practice.java>
