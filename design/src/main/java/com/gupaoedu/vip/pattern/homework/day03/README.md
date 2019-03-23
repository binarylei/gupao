# 【课后作业】深度分析代理模式

__作业及思考:__

1. 仿 JDK 动态代理实现原理，自己手写一遍。
2. 思考：为什么 JDK 动态代理中要求目标类实现的接口数量不能超过 65535 个？
3. 结合自身的业务场景用代理模式进行重构。

提交地址：<https://gper.gupaoedu.com/articleContent?id=666>

### 一、仿 JDK 动态代理实现原理，自己手写一遍

见 com.gupao.binarylei.design.homework.day03.jdk

### 二、思考：为什么 JDK 动态代理中要求目标类实现的接口数量不能超过 65535 个？

JVM 规定 class 文件的结构如下：

```text
ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;         // 常量池
    cp_info        constant_pool[constant_pool_count-1];
    u2             access_flags;                // 类基本信息
    u2             this_class;                  // 类名
    u2             super_class;                 // 父类信息
    u2             interfaces_count;            // 接口信息
    u2             interfaces[interfaces_count];
    u2             fields_count;                // 字段信息
    field_info     fields[fields_count];
    u2             methods_count;               // 方法信息
    method_info    methods[methods_count];
    u2             attributes_count;            // 属性信息
    attribute_info attributes[attributes_count];
}
```

其中下面两项规定了类的接口定义，interfaces_count 表示该类接口的数量，用 u2 两个字节表示，最大 65535，所以 JDK 动态代理中要求目标类实现的接口数量不能超过 65535 个。

```text
u2             interfaces_count;
u2             interfaces[interfaces_count];
```

### 三、结合自身的业务场景用代理模式进行重构。
