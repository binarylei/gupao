package com.gupaoedu.vip.pattern.homework.day03.jdk;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author: leigang
 * @version: 2018-10-02
 */
public class MyProxy {

    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, MyInvocationHandler h) {
        FileWriter out = null;
        try {
            // 1. 动态生成源代码 .java 文件
            String src = generateSrc(interfaces);

            // 2. .java 文件生成到磁盘
            File file = new File(MyProxy.class.getResource("").getPath() + "$Proxy1.java");
            out = new FileWriter(file);
            out.write(src);
            out.flush();
            out.close();

            // 3. 把 .java 文件编译成 .class 文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(
                    null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask task = compiler.getTask(
                    null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4. 编译生成的 .class 类到 JVM 中
            Class<?> clazz = Class.forName("com.gupao.binarylei.design.homework.day03.jdk.$Proxy1");

            // 5. 返回字节码重组以后新代理对象
            Constructor<?> constructor = clazz.getConstructor(MyInvocationHandler.class);
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final String ln = "\r\n";

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.gupao.binarylei.design.homework.day03.jdk;").append(ln);
        sb.append("import com.gupao.binarylei.design.homework.day03.jdk.UserService;").append(ln);
        sb.append("import java.lang.reflect.Method;").append(ln);
        sb.append("public final class $Proxy1 implements ").append(interfaces[0].getSimpleName()).append(" {").append(ln);
        sb.append("private static MyInvocationHandler h;").append(ln);
        sb.append("public $Proxy1(MyInvocationHandler h) throws Exception {").append(ln);
        sb.append("this.h = h;").append(ln);
        sb.append("}").append(ln);

        for (Class<?> clazz : interfaces) {
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                sb.append("public final void say() {").append(ln);
                sb.append("try {").append(ln);
                sb.append("Method m = Class.forName(\"").append(clazz.getName()).append("\").getMethod(\"")
                        .append(m.getName()).append("\", new Class[0]);").append(ln);
                sb.append("h.invoke(this, m, (Object[]) null);").append(ln);
                sb.append("} catch (Throwable e) {").append(ln);
                sb.append("e.printStackTrace();").append(ln);
                sb.append("}").append(ln);
                sb.append("}").append(ln);
            }
        }
        sb.append("}").append(ln);
        return sb.toString();
    }

}
