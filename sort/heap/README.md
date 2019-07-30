### Heap Properties
> https://zhuanlan.zhihu.com/p/52513668
> https://zhuanlan.zhihu.com/p/39615266
> https://www.zhihu.com/question/23873747
> https://cs.stackexchange.com/questions/3/why-is-quicksort-better-than-other-sorting-algorithms-in-practice
- Max Heap: all the nodes' value must smaller than their parants.
- Heap is a complete binary tree.
- Heapify time is `O(n)`.
- Insert/remove time is `O(logn)`.
- Java PriorityQueue source code, heapify() method in `initFromCollection()` method.