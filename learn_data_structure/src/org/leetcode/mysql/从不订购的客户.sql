/*
题目:https://leetcode-cn.com/problems/customers-who-never-order
某网站包含两个表，Customers 表和 Orders 表。编写一个 SQL 查询，找出所有从不订购任何东西的客户。
Customers 表：
+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Orders 表：
+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
例如给定上述表格，你的查询应返回：
+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+
*/
-- 我的答案
select name as customers from customers where id not in (select customerId from orders)

--其他答案
select c.Name as Customers from Customers c left join Orders o on c.Id=o.CustomerId where CustomerId is null;