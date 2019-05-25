package org.lsh.demo.service.impl;

import org.lsh.demo.model.UserInfo;
import org.lsh.demo.service.SendSms;

/**
 * @Title: java类的类型
 * @Description: java类作用描述
 * @Author: lsh
 * @CreateDate: 2018/7/23 18:04
 * @Version: 1.0
 */
public class SendSmsImpl implements SendSms {
    @Override
    public boolean sendMail(UserInfo userInfo) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("已发送Email给"+userInfo.getUserName()+"到【"+userInfo.getUserEmail()+"】");
        return true;

    }
}
