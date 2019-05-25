package org.lsh.mybatis.session;

import org.lsh.mybatis.binding.MapperProxy;
import org.lsh.mybatis.config.Configuration;
import org.lsh.mybatis.config.MappedStatement;
import org.lsh.mybatis.excutor.DefaultExecutor;
import org.lsh.mybatis.excutor.Executor;

import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Map;

/**
 * @Title: java类的类型
 * @Author: lsh
 * @CreateDate: 2018/8/24 11:21
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration conf;
    private Executor executor;

    public DefaultSqlSession(Configuration conf) {
        this.conf = conf;
        executor = new DefaultExecutor(conf);
    }

    public <T> T selectOne(String statement, Object parameter) {
        List<T> selectList = this.selectList(statement, parameter);
        if (selectList == null || selectList.size() == 0) {
            return null;
        }
        if(selectList.size()==1){
            return selectList.get(0);
        }else{
            throw new RuntimeException("too many result!");
        }
    }

    public <E> List<E> selectList(String statement, Object parameter) {
        MappedStatement mappedStatement = conf.getMapperStatements().get(statement);
        return executor.query(mappedStatement, parameter);
    }

    public <T> T getMapper(Class<T> type) {
        MapperProxy mp = new MapperProxy(this);
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, mp);
    }
}
