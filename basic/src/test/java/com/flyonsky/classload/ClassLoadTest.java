package com.flyonsky.classload;

import org.junit.Test;

/**
 * @author luowengang
 * @date 2022/1/28
 */
public class ClassLoadTest {

    @Test
    public void testClassLoader(){
        ClassLoader loader = this.getClass().getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
        System.out.println(loader);
    }

    @Test
    public void testClassLoader2(){
        System. out.println(System.getProperty( "sun.boot.class.path"));
        System. out.println(System.getProperty( "java.ext.dirs"));
        System. out.println(System.getProperty( "java.class.path"));
    }
}
