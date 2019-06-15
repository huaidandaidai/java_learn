/*
  题目：https://leetcode-cn.com/problems/duplicate-emails/
  编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
  示例：
  +----+---------+
  | Id | Email   |
  +----+---------+
  | 1  | a@b.com |
  | 2  | c@d.com |
  | 3  | a@b.com |
  +----+---------+
  根据以上输入，你的查询应返回以下结果：
  +---------+
  | Email   |
  +---------+
  | a@b.com |
  +---------+
  说明：所有电子邮箱都是小写字母。
*/

-- 我的答案
select email from person group by email having count(email)>1;
select distinct p1.email as Email from person p1,person p2 where p1.email=p2.email and p1.id !=p2.id;
-- 其他答案
select email
from (
  select email,count(email) as num
  from person group by email
) p
where p.num>1;