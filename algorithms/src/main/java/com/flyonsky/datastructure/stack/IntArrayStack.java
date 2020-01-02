package com.flyonsky.datastructure.stack;

public class IntArrayStack {

    private int[] values;

    private int size;

    public IntArrayStack(){
        values = new int[10];
    }

    public void push(int data){
        if(size < values.length - 1){
            values[size++] = data;
        }else{

        }
    }

    public int pop(){
        if(size > 0){
            return values[size--];
        }else{
            throw new RuntimeException("not data");
        }
    }
}
