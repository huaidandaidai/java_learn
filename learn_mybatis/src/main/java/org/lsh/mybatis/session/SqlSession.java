package org.lsh.mybatis.session;

import java.util.List;

/**
 * @Title: Mybatis暴露给外部的接口，时限增删改查的能力
 * @Author: lsh
 * @CreateDate: 2018/8/24 10:48
 */
public interface SqlSession {
    /**
     * 根绝传入的条件查询单一结果
     * @param statement 方法对应的sql语句
     * @param parameter 要传入的sql语句中的查询参数
     * @param <T> 返回指定的结果对象
     * @return 返回指定的结果对象
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 根据条件查询，返回泛型集合
     * @param statement 对应的sql语句
     * @param parameter  sql传入的参数
     * @param <E> 集合类型
     * @return 返回list
     */
    <E> List<E> selectList(String statement, Object parameter);

    <T> T getMapper(Class<T> type);
}
