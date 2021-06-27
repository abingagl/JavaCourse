package week1;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Base64;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/06/27
 */
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) throws Exception {
        final String className = "Hello";
        final String methodName = "hello";


        ClassLoader loader = new HelloClassLoader();
        Class clazz = loader.loadClass(className);
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(clazz.getSimpleName() + "." + m.getName());
        }
        Object instance = clazz.newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(instance);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        System.out.println(name);
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(Thread.currentThread().getContextClassLoader().getResource("Hello.xlass"));
//        String resourcePath = name.replace(".", "/");
//        // 文件后缀
//        final String suffix = ".xlass";
//        // 获取输入流
//        InputStream input = this.getClass().getClassLoader().getResourceAsStream("Hello.xlass");
        File file = new File("src/week1/Hello.xlass");
        InputStream input = null;
        try {
            input = new FileInputStream(file);
            int len = input.available();
            byte[] bytes = new byte[len];
            input.read(bytes);
            byte[] res = decode(bytes);
            return defineClass(name, res, 0, res.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(input);
        }
        return null;
    }

    public byte[] decode(byte[] bytes) {
        byte[] res = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            res[i] = (byte)(255 - bytes[i]);
        }
        return res;
    }

    private static void close(Closeable res) {
        if (null != res) {
            try {
                res.close();
            } catch(IOException e) {
                e.printStackTrace();
            }

        }
    }
}
