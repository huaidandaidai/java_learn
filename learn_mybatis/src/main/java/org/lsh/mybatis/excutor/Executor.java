package org.lsh.mybatis.excutor;

import org.lsh.mybatis.config.MappedStatement;

import java.util.List;

/**
 * @Title: java类的类型
 * @Author: lsh
 * @CreateDate: 2018/8/24 15:17
 */
public interface Executor {
    /**
     * 查询接口
     * @param ms 封装sql语句的MappedStatement对象
     * @param parameter 传入sql的参数
     * @return 将数据转换成指定对象的结果集
     */
    <E> List<E> query(MappedStatement ms, Object parameter);
}
