package com.flyonsky.jvm;

/**
 * @author luowengang
 * @date 2021/1/15 22:11
 */
public class JavaVMStackSOF {
    private long stackLength = 1;
    public void stacklength(){
        stackLength++;
        stacklength();
    }
    /**
     * VM Args: -Xss128k
     */
    public static void main(String[] args) {
        JavaVMStackSOF o = new JavaVMStackSOF();
        try{
            o.stacklength();
        } catch(Throwable e ){
            System. out.println("stack legth:" + o.stackLength );
            throw e ;
        }
    }
}
