package week1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloXlassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> helloXlass = new HelloXlassLoader().findClass("Hello");
            Object obj = helloXlass.getConstructor().newInstance();
            Method method = helloXlass.getMethod("hello");
            method.invoke(obj);
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } 
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] b = loadXlassFromFile("Hello.xlass");
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadXlassFromFile(String fileName) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        try {
            while ((nextValue = inputStream.read()) != -1) {
                byteStream.write(255 - nextValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}