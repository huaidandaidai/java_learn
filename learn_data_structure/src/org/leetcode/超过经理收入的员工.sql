/*
题目：https://leetcode-cn.com/problems/employees-earning-more-than-their-managers/
Employee表包含所有员工，他们的经理也属于员工。每个员工都有一个 Id，此外还有一列对应员工的经理的 Id。
+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
给定 Employee 表，编写一个 SQL 查询，该查询可以获取收入超过他们经理的员工的姓名。
*/
--我的答案
select a.name as employee from employee a where a.salary >( select salary from employee b where b.id= a.mnagerid);

--其他最快答案
select a.Name as Employee from Employee a join Employee b on a.ManagerId=b.id where a.Salary>b.Salary;

SELECT
	a.Name as Employee
FROM
	employee AS a,
	employee AS b
WHERE
	a.ManagerId=b.Id
		AND a.Salary > b.Salary