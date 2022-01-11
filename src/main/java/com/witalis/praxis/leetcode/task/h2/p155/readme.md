# [LeetCode][leetcode] task # 155: [Min Stack][task]

Description
-----------

> Design a stack that supports push, pop, top, and
> retrieving the minimum element in constant time.
> 
> Implement the MinStack class:
> * MinStack() initializes the stack object.
> * void push(int val) pushes the element val onto the stack.
> * void pop() removes the element on the top of the stack.
> * int top() gets the top element of the stack.
> * int getMin() retrieves the minimum element in the stack.

Example
-------

```sh
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2
```

Solution
--------

| Task | Solution              |
|:----:|:----------------------|
| 155  | [Min Stack][solution] |


[leetcode]: <http://leetcode.com/>
[task]: <https://leetcode.com/problems/min-stack/>
[solution]: <https://github.com/wellaxis/witalis-jkit/blob/main/module/tasks/src/main/java/com/witalis/jkit/tasks/core/task/leetcode/h2/p155/option/Practice.java>
