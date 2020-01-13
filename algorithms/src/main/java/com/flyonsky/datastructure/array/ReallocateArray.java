package com.flyonsky.datastructure.array;

/**
 * 动态调整大小的数组
 *
 * @author luowengang
 * @date 2020/1/13
 */
public class ReallocateArray<T> {
    /** 默认数组大小 **/
    private final static int DEFAUT_SIZE = 16;
    /** 数组 **/
    private T[] values;
    /** 记录数 **/
    private int count;

    /**
     * 构造函数
     */
    public ReallocateArray(){
        values = (T[])(new Object[DEFAUT_SIZE]);
    }

    /**
     * 构造函数
     * @param size 数组大小
     */
    public ReallocateArray(int size){
        if(size > 0){
            values = (T[])(new Object[size]);
        }else{
            values = (T[])(new Object[DEFAUT_SIZE]);
        }
    }

    /**
     * 添加数据
     * @param data 数据
     */
    public void add(T data){
        if(count == values.length){
            reallocate();
        }
        values[count++] = data;
    }

    /**
     * 获取指定位置的数据
     * @param index
     * @return
     */
    public T getData(int index){
        if(index < count){
            return values[index];
        }else{
            throw new RuntimeException("索引超过数组范围");
        }
    }

    /**
     *  重新分配数组空间
     */
    private void reallocate(){
        if(count == values.length){
            T[] tmpValues = (T[])new Object[values.length * 2];
            for(int i = 0;i < values.length;i++){
                tmpValues[i] = values[i];
            }
            values = tmpValues;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<count;i++){
            sb.append(values[i].toString()).append("\r\n");
        }
        sb.append("array size : ").append(values.length).append("\r\n");
        return sb.toString();
    }
}
