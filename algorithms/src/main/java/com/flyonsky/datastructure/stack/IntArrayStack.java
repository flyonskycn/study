package com.flyonsky.datastructure.stack;

/**
 * 栈的数组实现
 */
public class IntArrayStack {

    private int[] values;

    private int size;

    public IntArrayStack(){
        values = new int[10];
    }

    /**
     * 入栈方法
     * @param data 数据
     */
    public void push(int data){
        if(size < values.length - 1){
            values[size++] = data;
        }else{

        }
    }

    /**
     * 出栈方法
     * @return 数据
     */
    public int pop(){
        if(size > 0){
            return values[size--];
        }else{
            throw new RuntimeException("not data");
        }
    }
}
