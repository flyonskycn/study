package com.flyonsky.datastructure.stack;

/**
 * 栈的数组实现
 * @author luowengang
 */
public class IntArrayStack {
    /**
     * 栈默认大小
     */
    private static final int DEFAULT_SIZE = 10;
    /**
     *  存储栈值的数组
     */
    private int[] values;
    /**
     *  栈已存储的值
     */
    private int size;

    public IntArrayStack(){
        values = new int[DEFAULT_SIZE];
    }

    /**
     * 入栈方法
     * @param data 数据
     */
    public void push(int data){
        // 重新分配空间
        reallocate();
        values[size++] = data;
    }

    /**
     * 出栈方法
     * @return 数据
     */
    public int pop(){
        if(size > 0){
            // 重新分配空间
            reallocate();
            return values[--size];
        }else{
            throw new RuntimeException("not data");
        }
    }

    /**
     * 栈空判断
     * @return true:空,false:非空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 重新分配存储空间
     */
    void reallocate(){
        // 数组长度的一半
        int halfLenth = values.length >> 1;
        // 数组已满
        if(size == values.length){
            // 新申请两们的存储空间
            int[] tmpValues = new int[values.length * 2];
            for(int i = 0;i<values.length;i++){
                tmpValues[i] = values[i];
            }
            values = tmpValues;
        }else if(size < halfLenth && halfLenth > DEFAULT_SIZE){
            // 数组已使用空间小于一半 且 数组的一半空间大于默认数组长度
            int[] tmpValues = new int[halfLenth];

            for(int i = 0;i<values.length;i++){
                tmpValues[i] = values[i];
            }
            values = tmpValues;
        }
    }
}
