/*
题目：https://leetcode-cn.com/problems/rising-temperature
给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
+---------+------------------+------------------+
| Id(INT) | RecordDate(DATE) | Temperature(INT) |
+---------+------------------+------------------+
|       1 |       2015-01-01 |               10 |
|       2 |       2015-01-02 |               25 |
|       3 |       2015-01-03 |               20 |
|       4 |       2015-01-04 |               30 |
+---------+------------------+------------------+
例如，根据上述给定的 Weather 表格，返回如下 Id:
+----+
| Id |
+----+
|  2 |
|  4 |
+----+
 */

 -- 我的答案
 select w1.id from weather w1,weather w2 where w1.recorddate = w2.recorddate+1 and w1.temperature >w2.temperature;
(未通过)
 --其他答案：
 select w1.Id from Weather w1 join Weather w2 on datediff(w1.RecordDate,w2.RecordDate)=1 and w1.Temperature>w2.Temperature;
 SELECT later.ID AS 'ID' FROM Weather AS previous, Weather AS later WHERE  previous.Temperature < later.Temperature and DATEDIFF(later.RecordDate, previous.RecordDate) = 1;
