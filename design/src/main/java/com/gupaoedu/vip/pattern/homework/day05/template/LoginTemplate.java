package com.gupaoedu.vip.pattern.homework.day05.template;

/**
 * Java 回调实现模板方法
 *
 * @author leigang
 * @version 2019-03-21
 */
public class LoginTemplate {

    public final boolean login(LoginModel lm, LoginCallback callback) {
        //1：根据登录人员的编号去获取相应的数据
        LoginModel dbLm = callback.getUser(lm.getId());
        if (dbLm != null) {
            //2：对密码进行加密
            String encryptPwd = callback.encrypt(lm.getPassword());
            //把加密后的密码设置回到登录数据模型里面
            lm.setPassword(encryptPwd);
            //3：判断是否匹配
            return callback.match(lm, dbLm);
        }
        return false;
    }
}
