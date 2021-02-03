package com.flyonsky.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author luowengang
 * @date 2021/1/15 22:48
 */
public class OOMObjectMethodOF {
    static class OOMObject{

    }

    /**
     * VM Args -XX:PermSize=5M -XX:MaxPermSize=5M
     */
    public static void main(String[] args) {
        while(true ){
            Enhancer e = new Enhancer();
            e.setSuperclass(OOMObject. class);
            e.setUseCache( false);
            e.setCallback( new MethodInterceptor() {

                @Override
                public Object intercept(Object obj , Method arg1, Object[] arg2 ,
                                        MethodProxy proxy) throws Throwable {
                    return proxy .invokeSuper(obj, arg2);
                }
            });
            e.create();
        }
    }
}
