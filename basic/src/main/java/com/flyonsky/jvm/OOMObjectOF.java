package com.flyonsky.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luowengang
 * @date 2021/1/15 22:19
 */
public class OOMObjectOF {
    static class OOMObject{

    }
    /**
     * VM Args -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true ){
            list.add( new OOMObject());
        }
    }
}
