package com.flyonsky;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态块子类
 * @author luowengang
 */
public class StaticChild extends StaticParent {
    private final static Map<String, Object> CHILD_MAP = new HashMap<>();

    static {
        if(CHILD_MAP == null){
            System.out.println("child static variable is null");
        }else{
            System.out.println("child static variable is not null");
    }
    }

    public static void print(){
        System.out.println("static method called");
    }
}
