package org.lsh.mybatis.config;

/**
 * @Title: java类的类型
 * @Author: lsh
 * @CreateDate: 2018/8/24 10:37
 */
public class MappedStatement {
    private String sourceId;
    private String resultType;
    private String sql;
    private String namespace;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
