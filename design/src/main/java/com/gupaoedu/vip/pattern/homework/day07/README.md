# 设计模式对比

__作业及思考:__

1. 用一句自己的话总结学过的设计模式（要精准）。
2. 列举 SpringAOP、IOC、DI 应用的代码片段。


提交地址：<https://gper.gupaoedu.com/articleContent?id=701>

### 一、用一句自己的话总结学过的设计模式（要精准）

设计模式 | 一句话归纳 | 举例
---- | ---- | ----
工厂模式(Factory) | 只对结果负责，封装创建过程 | BeanFactory、Calender
单例模式(Singleton) | 保证独一无二 | ApplicationContext、Calender
原型模式(Factory) | 拔一根毛，吹出千万个 | ArrayList
代理模式(Proxy) | 找人办事，增强职责 | JdkDynamicAopProxy、CglibAopProxy
委派模式(Delegate) | 干活算你的，功劳算我的 | DispatcherServlet
策略模式(Strategy) | 用户选择，结果统一 | InstantiationStrategy
模板模式(Template) | 流程标准化，自己实现定制 | JdbcTemplate、HttpServlet
适配器模式(Adapter) | 兼容转换头 | AdvisorAdapter、HandlerAdapter
装饰器模式(Decorator) | 包装，同宗同源 | Java IO
观察者模式(Observer) | 任务完成时通知 | ContextLoaderListener


### 二、列举 SpringAOP、IOC、DI 应用的代码片段

#### Spring AOP

```java
@Aspect
@Component
public class AspectTest {

    @Pointcut("execution(public void com.github.binarylei.spring02.aop.TargetProxy.test(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @After("pointcut()")
    public void afterTest() {
        System.out.println("afterTest");
    }

    @AfterReturning("pointcut()")
    public void afterReturningTest() {
        System.out.println("afterTest");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowingTest() {
        System.out.println("afterTest");
    }

    @Around("pointcut()")
    public Object aroundTest(ProceedingJoinPoint joinPoint) {
        System.out.println("around beforeTest");
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("around afterTest");
        return obj;
    }
}
```

#### Spring IOC

```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
User user = context.getBean(User.class);
```

#### Spring DI

```java
@Component
public class Bean2 {

    @Autowired
    private Car car;

    @Qualifier("car")
    @Autowired
    private Car car1;
    
    @Value("${age}")
    private int age2;
}
```
```