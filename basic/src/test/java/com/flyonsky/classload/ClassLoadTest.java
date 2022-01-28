package com.flyonsky.classload;

import org.junit.Test;

import java.lang.reflect.Method;

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

    @Test
    public void testFileClassLoader(){
        String classDataRootPath = "D:/log";
        FileClassLoader fscl1 = new FileClassLoader(classDataRootPath);
        FileClassLoader fscl2 = new FileClassLoader(classDataRootPath);
        String className = "com.flyonsky.classload.Sample" ;
        try {
            Class<?> class1 = fscl1.loadClass(className );
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl2.loadClass(className );
            Object obj2 = class2.newInstance();
            Method setSampleMethod = class1.getMethod("setSample" , java.lang.Object.class );
            setSampleMethod.invoke(obj1 , obj2 );
            System.out.println(obj1 );
            System.out.println(obj2 );
        } catch (Exception e ) {
            e.printStackTrace();
        }
    }
}
