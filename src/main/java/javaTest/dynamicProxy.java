package javaTest;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class dynamicProxy {
    public static void main(String[] args) throws IOException {
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy", new Class[]{UserService.class});
        FileOutputStream fileInputStream = new FileOutputStream("hello.class");
        fileInputStream.write(bytes);
        fileInputStream.flush();
        fileInputStream.close();
        System.out.println("完毕");
    }
}

interface UserService {
    void func1();
}
