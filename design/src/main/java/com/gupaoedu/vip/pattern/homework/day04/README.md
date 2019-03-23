# 模板模式及适配器模式

__作业及思考:__

1. 举例 Spring 源码中你见过的委派模式，并画出类关系图。
2. 利用策略模式重构一段业务代码。

提交地址：<https://gper.gupaoedu.com/articleContent?id=671>

### 一、举例 Spring 源码中你见过的委派模式，并画出类关系图。

![ApplicationContext](https://img2018.cnblogs.com/blog/1322310/201903/1322310-20190323182512874-571019236.png)

Spring 中 ApplicationContext 实现了 EnvironmentCapable, ListableBeanFactory, HierarchicalBeanFactory, MessageSource, ApplicationEventPublisher, ResourcePatternResolver 等接口，但实际上都是委托给对应的实现类完成的。

* `ListableBeanFactory, HierarchicalBeanFactory` 委托给 DefaultListableBeanFactory
* `EnvironmentCapable` 委托给 StandardEnvironment 或 StandardServletEnvironment
* `MessageSource` 委托给 DelegatingMessageSource
* `ApplicationEventPublisher` 委托给 SimpleApplicationEventMulticaster
* `ResourcePatternResolver` 委托给 PathMatchingResourcePatternResolver

### 二、利用策略模式重构一段业务代码

com.gupao.binarylei.design.homework.day04.strategy

价格管理，主要完成计算向客户所报价格的功能，以前的代码如下，有大量的 if else 

```java
public double quote(double goodsPrice, String customerType) {
    if ("普通客户".equals(customerType)) {
        return this.calcPriceForNormal(goodsPrice);
    } else if ("老客户".equals(customerType)) {
        return this.calcPriceForOld(goodsPrice);
    } else if ("大客户".equals(customerType)) {
        return this.calcPriceForLarge(goodsPrice);
    }
    //其余人员都是报原价
    return goodsPrice;
}
```

现对其进行重构，将每个客户类型报价抽象为一个策略，类结构如下：

![CustomerStrategy 报价](https://img2018.cnblogs.com/blog/1322310/201903/1322310-20190323180809453-754223556.png)

使用时需要指定对应的策略：

```java
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
```