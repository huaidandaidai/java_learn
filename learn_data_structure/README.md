# Java数据结构和算法

## leetcode算法题

## java中的集合类

## enjoy 享学课堂中的作业和代码

##  缓存淘汰机制
**内存缓存**：预先将数据写到了容器之中等数据存储单元，就是软件内存缓存；

**内存缓存淘汰机制**：[内存淘汰机制](https://blog.csdn.net/youanyyou/article/details/78989956)
 1. FIFO (First In ,First Out)  先进先出；如果一个数据最先进入缓存，则应该最早淘汰掉。
 2. LFU  (Least Frequently Used) 最不频繁使用的；使用一个计数器来记录条目被访问的频率，最低访问数的条目最先被移除。
 3. LRU  (Least Recently Used)   最近使用最少的;将最近使用的条目存放到缓存的顶端，当缓存达到极限后，条目从底部开始移除。
 
 **LRU算法实现**：
 
 ![示例图](https://github.com/huaidandaidai/java_learn/blob/master/learn_data_structure/src/org/lsh/lru/LRU%E7%BC%93%E5%AD%98%E6%B7%98%E6%B1%B0%E6%9C%BA%E5%88%B6.jpg)
 1. 新数据插入到链表头部；
 2. 当缓存命中（即缓存数据被访问），数据要移动到表头。
 3. 当链表满时将尾部的数据丢弃掉。
 
 ## 队列实现
 **实现原理**：
 1. 队列的特性：先进先出，后进后出。
 2. 实现方式：数组、链表.
 
 ## 栈实现
 **实现原理**：
  1. 栈的特性：先进后出，后进先出。
  2. 实现方式：数组、链表.