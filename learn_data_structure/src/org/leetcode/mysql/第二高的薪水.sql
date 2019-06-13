/*
  题目：https://leetcode-cn.com/problems/second-highest-salary/
  编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
  +----+--------+
  | Id | Salary |
  +----+--------+
  | 1  | 100    |
  | 2  | 200    |
  | 3  | 300    |
  +----+--------+
  例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
  +---------------------+
  | SecondHighestSalary |
  +---------------------+
  | 200                 |
  +---------------------+
*/
-- 我的答案
select
 ifnull((select distinct salary  from employee order by salary desc limit 1,1),null)
as SecondHighestSalary

-- 其他答案
select max(salary) as SecondHighestSalary from Employee e where Salary < (select max(salary)from Employee) limit 1