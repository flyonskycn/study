package com.flyonsky.datastructure.array;

/**
 * 固定空间的有序数组
 *
 * @author luowengang
 * @date 2020/1/13
 */
public class OrderlyIntArray {
    /** 数组对象 **/
    private int[] values;
    /** 记录数 **/
    private int count;

    /**
     * 构造函数
     */
    public OrderlyIntArray(){
        values = new int[128];
    }

    /**
     * 构造函数
     * @param size 数组大小
     */
    public OrderlyIntArray(int size){
        if(size > 0){
            values = new int[size];
        }else{
            values = new int[128];
        }
    }

    /**
     * 往有序数组中添加元素
     * @param data 值
     * @return
     */
    public boolean add(int data){
        boolean flag = false;
        if(count < values.length){
            for(int i = count-1;i>=0;i--){
                if(values[i] > data){
                    values[i + 1] = values[i];
                }else{
                    values[i + 1] = data;
                    break;
                }
            }
            count++;
            flag = true;
        }
        return flag;
    }

    /**
     * 删除有序数组中指定值的记录
     * @param data 值
     * @return
     */
    public boolean remove(int data){
        boolean flag = false;
        int index = this.binarySearch(values, 0, count - 1, data);
        if(index >= 0){
            for(int i = index + 1;i < count;i++){
                values[i-1] = values[i];
            }
            flag = true;
        }
        return flag;
    }

    /**
     * 将有序数组中旧值更换为新值
     * @param oldValue 旧值
     * @param newValue 新值
     * @return
     */
    public boolean update(int oldValue, int newValue){
        boolean flag = false;
        int index = this.binarySearch(values,0,count-1,oldValue);
        if(index >= 0){
            for(int i = index+1; i < count; i++){
                if(values[i] >= newValue){
                    values[i-1] = newValue;
                    break;
                }else{
                    values[i - 1] = values[i];
                }
                values[i] = newValue;
            }
            flag = true;
        }
        return flag;
    }

    /**
     * 二分查找
     * @param vals 有序数组
     * @param startIndex 开始index
     * @param endIndex 结束index
     * @param data 查找的值
     * @return data所在index -1表示不在有数组中
     */
    int binarySearch(int[] vals,int startIndex,int endIndex,int data){
        if(startIndex > endIndex || startIndex == endIndex) {
            if(vals[startIndex] == data){
                return startIndex;
            }else{
                return -1;
            }
        }else{
            int midIndex = (startIndex + endIndex) / 2;
            if(vals[midIndex] > data){
                endIndex = midIndex -1;
            }else if(vals[midIndex] < data){
                startIndex = midIndex + 1;
            }else{
                return midIndex;
            }
            return binarySearch(vals, startIndex, endIndex, data);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<count;i++){
            sb.append(values[i]).append(",");
        }
        sb.append("\r\n").append("array size : ").append(values.length).append("\r\n");
        return sb.toString();
    }
}
