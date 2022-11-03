# [LeetCode][leetcode] task # 232: [Implement Queue using Stacks][task]

Description
-----------

> Implement a first in first out (FIFO) queue using only two stacks.
> The implemented queue should support all the functions
> of a normal queue (`push`, `peek`, `pop`, and `empty`).
> 
> Implement the `MyQueue` class:
> * `void push(int x)` Pushes element x to the back of the queue.
> * `int pop()` Removes the element on the front of the queue and returns it.
> * `int peek()` Returns the element on the front of the queue.
> * `boolean empty()` Returns `true` if the queue is empty, `false` otherwise.
>
> **Notes:**
> * You must use **only** standard operations of a stack,
> which means that only `push to top`, `peek/pop from top`,
> `size` and `is empty` operations are valid.
> * Depending on your language, the stack may not be supported natively.
> You may simulate a stack using a list or deque (double-ended queue)
> as long as you use only a stack's standard operations.

Example
-------

```sh
Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]
Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek();  // return 1
myQueue.pop();   // return 1, queue is [2]
myQueue.empty(); // return false
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 232  | [Implement Queue using Stacks][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/implement-queue-using-stacks/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h3/p232/option/Practice.java>
