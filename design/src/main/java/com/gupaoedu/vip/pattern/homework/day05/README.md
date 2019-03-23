# 模板模式及适配器模式

__作业及思考:__

1. 思考：模板模式除了继承以外，还有哪些实现方式？
2. 使用适配模式，重构一段需要升级功能且兼容老系统的业务代码。

提交地址：<https://gper.gupaoedu.com/articleContent?id=684>

### 一、思考：模板模式除了继承以外，还有哪些实现方式？

可以使用 Java 的回调，在回调的接口中定义模板处理的各个操作。

```java
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
```

### 二、使用适配模式，重构一段需要升级功能且兼容老系统的业务代码。

web 页面有一段导出文件的功能，默认是导出为 excel，现在需要添加新的功能，支持导出为 csv 格式。

旧的代码为：

```java
// 旧的代码仅支持导出为 excel 格式
public class ExcelExport {
    public void export(List list) {
        System.out.println("export excel");
    }
}
```

现在需要升级支持导出为 csv 格式，添加适配器接口：

```java
public interface ExportAdaptor {
    void export(List list);
}
```

ExcelExport 和 CsvExport 同时实现 ExportAdaptor 接口进行适配，这样原有的方法 ExcelExport 不需要改变

![适配器模式](https://img2018.cnblogs.com/blog/1322310/201903/1322310-20190323193505639-719691779.png)
