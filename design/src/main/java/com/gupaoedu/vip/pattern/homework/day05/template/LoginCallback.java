package com.gupaoedu.vip.pattern.homework.day05.template;

/**
 * @author leigang
 * @version 2019-03-21
 */
public interface LoginCallback {

    LoginModel getUser(String id);

    String encrypt(String originPassword);

    boolean match(LoginModel lm, LoginModel dblm);
}
