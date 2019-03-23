package com.gupaoedu.vip.pattern.homework.day04.strategy.now;

import org.junit.Test;

public class Main {

    @Test
    public void test() {
        //1：选择并创建需要使用的策略对象
        Strategy strategy = new LargeCustomerStrategy();
        //2：创建上下文
        Price ctx = new Price(strategy);

        //3：计算报价
        double quote = ctx.quote(1000);
        System.out.println("向客户报价：" + quote);
    }
}