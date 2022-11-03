# [LeetCode][leetcode] task # 225: [Implement Stack using Queues][task]

Description
-----------

> Implement a last-in-first-out (LIFO) stack using only two queues.
> The implemented stack should support all the functions
> of a normal stack (`push`, `top`, `pop`, and `empty`).
> 
> Implement the `MyStack` class:
> * `void push(int x)` Pushes element x to the top of the stack.
> * `int pop()` Removes the element on the top of the stack and returns it.
> * `int top()` Returns the element on the top of the stack.
> * `boolean empty()` Returns `true` if the stack is empty, `false` otherwise.
>
> **Notes:**
> * You must use **only** standard operations of a queue,
> which means that only `push to back`, `peek/pop from front`,
> `size` and `is empty` operations are valid.
> * Depending on your language, the queue may not be supported natively.
> You may simulate a queue using a list or deque (double-ended queue)
> as long as you use only a queue's standard operations.

Example
-------

```sh
Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]
Explanation
MyStack myStack = new MyStack();
myStack.push(1); // stack is: [1]
myStack.push(2); // queue is: [2, 1] (leftmost is top of the stack)
myStack.top();   // return 2
myStack.pop();   // return 2
myStack.empty(); // return False
```

Solution
--------

| Task | Solution                                 |
|:----:|:-----------------------------------------|
| 225  | [Implement Stack using Queues][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/implement-stack-using-queues/>
[solution]: <https://github.com/wellaxis/praxis-leetcode/blob/main/src/main/java/com/witalis/praxis/leetcode/task/h3/p225/option/Practice.java>
