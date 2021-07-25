package homework.week5.q1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：zhang
 * @title ：1.（选做）使 Java 里的动态代理，实现一个简单的 AOP。
 * @date ：created in 2021/07/23
 */
public class ProxySample {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        ClassLoader classLoader = Hello.class.getClassLoader();
        Class[] interfaces = new Class[] {Hello.class};
        InvocationHandler handler = new ProxyHandler(hello);
        Hello proxy = (Hello) Proxy.newProxyInstance(
                classLoader,
                interfaces,
                handler
        );
        proxy.morning("there");


    }
}

interface Hello {
    void morning(String name);
}

class HelloImpl implements Hello {
    @Override
    public void morning(String name) {
        System.out.println("morning " + name);
    }
}

class ProxyHandler implements InvocationHandler {
    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(object, args);
        after();
        return null;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}