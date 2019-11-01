package com.flyonsky;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态变量与静态块父类
 * @author luowengang
 */
public class StaticParent {

    private final static Map<String, Object> PARENT_MAP = new HashMap<>();
    static {
        if(PARENT_MAP == null){
            System.out.println("parent static variable is null");
        }else{
            System.out.println("parent static variable is not null");
        }
    }
}
