package com.flyonsky;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态块子类
 * @author luowengang
 */
public class StaticChild extends StaticParent {
    private final static Map<String, Object> childMap = new HashMap<>();

    public static void print(){
        System.out.println("static method called");
    }
}
