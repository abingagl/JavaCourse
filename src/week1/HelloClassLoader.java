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
        Class clazz = new HelloClassLoader().findClass("Hello");
        Object hello = clazz.newInstance();
        Method method = clazz.getMethod("hello");
        method.invoke(hello);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("src/week1/Hello.xlass");
        try {
            InputStream input = new FileInputStream(file);
            byte[] bytes = new byte[input.available()];
            byte[] res = new byte[input.available()];
            input.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                res[i] = (byte)(255 - bytes[i]);
            }
            return defineClass(name, res, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);
    }
}
