package org.lsh.mybatis.mapper;

import org.lsh.mybatis.entity.TUser;

import java.util.List;

/**
 * @Title: java类的类型
 * @Author: lsh
 * @CreateDate: 2018/8/24 10:35
 */
public interface TUserMapper {
    TUser selectByPrimaryKey(String id);
    List<TUser> selectAll();
}
