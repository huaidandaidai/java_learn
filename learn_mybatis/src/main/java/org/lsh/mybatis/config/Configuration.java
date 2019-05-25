package org.lsh.mybatis.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: java类的类型
 * @Author: lsh
 * @CreateDate: 2018/8/24 10:38
 */
public class Configuration {
    private String jdbcDriver;
    private String jdbcUrl;
    private String jdbcUserName;
    private String jdbcPassword;

    private Map<String, MappedStatement> mapperStatements = new HashMap<String, MappedStatement>();

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUserName() {
        return jdbcUserName;
    }

    public void setJdbcUserName(String jdbcUserName) {
        this.jdbcUserName = jdbcUserName;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public Map<String, MappedStatement> getMapperStatements() {
        return mapperStatements;
    }

    public void setMapperStatements(Map<String, MappedStatement> mapperStatements) {
        this.mapperStatements = mapperStatements;
    }
}
