package org.lsh.mybatis.excutor;

import org.lsh.mybatis.config.Configuration;
import org.lsh.mybatis.config.MappedStatement;
import org.lsh.mybatis.reflection.ReflectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: java类的类型
 * @Author: lsh
 * @CreateDate: 2018/8/24 15:22
 */
public class DefaultExecutor implements Executor {
    private Configuration conf;

    public DefaultExecutor(Configuration conf) {
        this.conf = conf;
    }

    public <E> List<E> query(MappedStatement ms, Object parameter) {
        List<E> ret = new ArrayList<E>();
        Connection conn=null;
        PreparedStatement statement=null;
        ResultSet rs=null;
        try {
            Class.forName(conf.getJdbcDriver());
            conn = DriverManager.getConnection(conf.getJdbcUrl(), conf.getJdbcUserName(), conf.getJdbcPassword());
            statement = conn.prepareStatement(ms.getSql());
            parameterize(statement,parameter);
            rs = statement.executeQuery();
            handlerResultSet(rs,ret,ms.getResultType());
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }
    private void parameterize(PreparedStatement statement,Object parameter) throws SQLException {
        if(parameter instanceof Integer){
            statement.setInt(1,(Integer)parameter);
        }else if(parameter instanceof Long){
            statement.setLong(1,(Long)parameter);
        }else if(parameter instanceof String){
            statement.setString(1,(String)parameter);
        }
    }

    private <E> void handlerResultSet(ResultSet resultSet,List<E> ret,String className){
        Class<E> clazz=null;
        try {
            //通过反射获取类对象
            clazz=(Class<E>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()){
                //通过反射实例化对象
                Object entity = clazz.newInstance();
                //使用反射工具将resultSet中的数据填充到entity中
                ReflectionUtil.setPropToBeanFromResultSet(entity, resultSet);
                //对象加入返回集合
                ret.add((E) entity);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
