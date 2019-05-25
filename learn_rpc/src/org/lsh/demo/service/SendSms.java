package org.lsh.demo.service;


import org.lsh.demo.model.UserInfo;

/**
 * @Title: java类的类型
 * @Description: java类作用描述
 * @Author: lsh
 * @CreateDate: 2018/7/23 18:03
 * @Version: 1.0
 */
public interface SendSms {
    public boolean sendMail(UserInfo userInfo);
}
